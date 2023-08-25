package ProgettoSettimana06.GestioneIncendi.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Installazione extends Publisher implements Subscriber {// Subscriber di Sonda
	private int id;
	private List<Sonda> sondeAssociate;
	private Subscriber centroControllo;
	private String messaggioDaInviareAlCentroControllo;
	@Override
	public void receiveUpdate(int id, String latitude, String longitude, int smokeLevel) {
		this.sondeAssociate.forEach(sonda -> System.err.println(sonda.toString()));

	}

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
				this.messaggioDaInviareAlCentroControllo = "Segnalazione di leggero aumento di fumo. Monitorare attentamente la situazione.";
				break;
			case 7:
				this.messaggioDaInviareAlCentroControllo = "Incremento del fumo rilevato. Verificare possibili fonti d'incendio.";
				break;
			case 8:
				this.messaggioDaInviareAlCentroControllo = "Fumo significativo in aumento. Preparare risorse per intervento.";
				break;
			case 9:
				this.messaggioDaInviareAlCentroControllo = "Fumo denso e sospetto. Mobilitare squadre di emergenza e risorse.";
				break;
			case 10:
				this.messaggioDaInviareAlCentroControllo = "Situazione critica: fumo intenso. Attivare procedure di evacuazione e intervento immediato.";
				break;
			default:
				this.messaggioDaInviareAlCentroControllo = "Situazione stabile";

			}
		});
		this.centroControllo.receiveUpdate(id, messaggioDaInviareAlCentroControllo, messaggioDaInviareAlCentroControllo,
				id);
	}


}
