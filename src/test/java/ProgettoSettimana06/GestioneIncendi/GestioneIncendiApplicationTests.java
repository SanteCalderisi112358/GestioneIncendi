package ProgettoSettimana06.GestioneIncendi;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import ProgettoSettimana06.GestioneIncendi.entities.CentroControllo;
import ProgettoSettimana06.GestioneIncendi.entities.Installazione;
import ProgettoSettimana06.GestioneIncendi.entities.Sonda;
import ProgettoSettimana06.GestioneIncendi.entities.Subscriber;

@SpringBootTest
public class GestioneIncendiApplicationTests {
	Faker f = new Faker();
	@Test
	public void contextLoads() {

	}

	@Test
	public void testSondaSmokeLevel() {
		Sonda sonda = new Sonda(1, f.address().latitude(), f.address().longitude());
		sonda.setSmokeLevel(7);
		assertEquals(7, sonda.getSmokeLevel());
	}

	private void assertEquals(int i, int smokeLevel) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testInstallazioneAddSonda() {
		Installazione installazione = new Installazione(1);
		Sonda sonda = new Sonda(2, f.address().latitude(), f.address().longitude());
		List<Sonda> sonde = new ArrayList<>();
		installazione.setSondeAssociate(sonde);
		assertTrue(installazione.getSondeAssociate().contains(sonda));
	}

	private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testInstallazioneAddSubscriber() {
		Installazione installazione = new Installazione(1);
		CentroControllo centroControllo = new CentroControllo(2);

		installazione.addSubscriber(centroControllo);
		assertEquals(centroControllo, installazione.getCentroControllo());
	}

	private void assertEquals(CentroControllo centroControllo, Subscriber centroControllo2) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testSondaRemoveSubscriber() {
		Sonda sonda = new Sonda(1, f.address().latitude(), f.address().longitude());
		Installazione installazione = new Installazione(2);

		sonda.addSubscriber(installazione);
		sonda.removeSubscriber();
		assertNull(sonda.getInstallazioneSubscriber());
	}

	private void assertNull(Subscriber installazioneSubscriber) {
		// TODO Auto-generated method stub

	}

}

