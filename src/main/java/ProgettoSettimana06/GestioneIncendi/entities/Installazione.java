package ProgettoSettimana06.GestioneIncendi.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Installazione extends Publisher implements Subscriber {// Subscriber di Sonda
	private int id;
	private List<Sonda> sondeAssociate = new ArrayList<Sonda>();
	private Subscriber centroControllo;
	private String messaggioDaInviareAlCentroControllo;


	@Override
	public void addSubscriber(Subscriber subscriber) {
		this.centroControllo = subscriber;

	}

	@Override
	public void removeSubscriber() {
		this.centroControllo = null;

	}

	@Override
	public void makeAnnouncment() {
		this.sondeAssociate.forEach(sonda -> {
			switch (sonda.getSmokeLevel()) {
			case 6:
				System.err.println(
						"Segnalazione di leggero aumento di fumo. Monitorare attentamente la situazione. Sonda id = "
								+ sonda.getId());
				break;
			case 7:
				System.err.println("Incremento del fumo rilevato. Verificare possibili fonti d'incendio. Sonda id = "
						+ sonda.getId());

				break;
			case 8:
				System.err.println(
						"Fumo significativo in aumento. Preparare risorse per intervento. Sonda id = " + sonda.getId());
				break;
			case 9:
				System.err.println("Fumo denso e sospetto. Mobilitare squadre di emergenza e risorse. Sonda id = "
						+ sonda.getId());

				break;
			case 10:
				System.err.println(
						"Situazione critica: fumo intenso. Attivare procedure di evacuazione e intervento immediato. Sonda id = "
								+ sonda.getId());

				break;
			default:
				System.err.println("Situazione stabile. Sonda id = "+sonda.getId());

			}

		});

	}

	@Override
	public void receiveUpdateFromSonda(int idSonda, String latitude, String longitude, int smokeLevel) {
		if (smokeLevel > 5) {
			this.centroControllo.receiveUpdateFromInstallazione(this.id, idSonda, latitude, longitude, smokeLevel,
				this.messaggioDaInviareAlCentroControllo);
		}

	}

	@Override
	@Deprecated
	public void receiveUpdateFromInstallazione(int idInstallazione, int idSonda, String latitude, String longitude,
			int smokeLevel, String messaggio) {
		// TODO Auto-generated method stub

	}

	public Installazione(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Installazione [id=" + id + ", sondeAssociate=" + sondeAssociate + "]";
	}

}
