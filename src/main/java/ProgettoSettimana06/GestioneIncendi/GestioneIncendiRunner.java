package ProgettoSettimana06.GestioneIncendi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import ProgettoSettimana06.GestioneIncendi.entities.CentroControllo;
import ProgettoSettimana06.GestioneIncendi.entities.Installazione;
import ProgettoSettimana06.GestioneIncendi.entities.Sonda;

@Component
public class GestioneIncendiRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Faker f = new Faker();

		/* Inizializzo 9 Sonde con un id numerico e coordinate random mediante Faker */

		Sonda sonda01 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda02 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda03 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda04 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda05 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda06 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda07 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda08 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		Sonda sonda09 = new Sonda(f.number().numberBetween(1000, 9999), f.address().latitude(),
				f.address().longitude());
		/* Inizializzo 3 Installazioni con id random tramite Faker */
		Installazione installazione01 = new Installazione(f.number().numberBetween(10, 99));
		Installazione installazione02 = new Installazione(f.number().numberBetween(10, 99));
		Installazione installazione03 = new Installazione(f.number().numberBetween(10, 99));
		/* Inizializzo un unico Centro di Controllo */

		CentroControllo centroControllo = new CentroControllo(f.number().numberBetween(1, 9));

		/*
		 * Ad ogni gruppo di 3 sonde (Publisher) associo una Installazione (Subscriber)
		 * e viceversa
		 */
		sonda01.addSubscriber(installazione01);
		sonda02.addSubscriber(installazione01);
		sonda03.addSubscriber(installazione01);
		sonda04.addSubscriber(installazione02);
		sonda05.addSubscriber(installazione02);
		sonda06.addSubscriber(installazione02);
		sonda07.addSubscriber(installazione03);
		sonda08.addSubscriber(installazione03);
		sonda09.addSubscriber(installazione03);
		List<Sonda> sondeInstallazione01 = new ArrayList<>();
		List<Sonda> sondeInstallazione02 = new ArrayList<>();
		List<Sonda> sondeInstallazione03 = new ArrayList<>();
		sondeInstallazione01.add(sonda01);
		sondeInstallazione01.add(sonda02);
		sondeInstallazione01.add(sonda03);
		sondeInstallazione02.add(sonda04);
		sondeInstallazione02.add(sonda05);
		sondeInstallazione02.add(sonda06);
		sondeInstallazione03.add(sonda07);
		sondeInstallazione03.add(sonda08);
		sondeInstallazione03.add(sonda09);

		installazione01.setSondeAssociate(sondeInstallazione01);
		installazione02.setSondeAssociate(sondeInstallazione02);
		installazione03.setSondeAssociate(sondeInstallazione03);

		/* Associo le 3 Installazioni (Publisher) al Centro di Controllo e viceversa */

		installazione01.addSubscriber(centroControllo);
		installazione02.addSubscriber(centroControllo);
		installazione03.addSubscriber(centroControllo);
		List<Installazione> installazioniCentroControllo = new ArrayList<Installazione>();
		installazioniCentroControllo.add(installazione01);
		installazioniCentroControllo.add(installazione02);
		installazioniCentroControllo.add(installazione03);
		centroControllo.setInstallazioniAssociate(installazioniCentroControllo);


		/*
		 * Faccio un set di smokeLevel alle sonde delle 3 List<Sonda> con valori di fumo
		 * random
		 * 
		 */

		sondeInstallazione01.forEach(sonda -> {
			sonda.setSmokeLevel(f.number().numberBetween(1, 10));
			sonda.makeAnnouncment();
			installazione01.makeAnnouncment();

		});
		System.err.println("**********");
		sondeInstallazione02.forEach(sonda -> {
			sonda.setSmokeLevel(f.number().numberBetween(1, 10));
			sonda.makeAnnouncment();
			installazione02.makeAnnouncment();

		});
		System.err.println("**********");

		sondeInstallazione03.forEach(sonda -> {
			sonda.setSmokeLevel(f.number().numberBetween(1, 10));
			sonda.makeAnnouncment();
			System.err.println("**********");
			installazione03.makeAnnouncment();
			System.err.println("**********");

		});

//		sonda01.setSmokeLevel(7);
//		sonda02.setSmokeLevel(8);
//		sonda03.setSmokeLevel(4);
//		System.err.println(sonda01);
//		System.err.println(sonda02);
//		System.err.println(sonda03);
//		sonda01.makeAnnouncment();
//		sonda02.makeAnnouncment();
//		sonda03.makeAnnouncment();
//		installazione01.makeAnnouncment();


	}


}
