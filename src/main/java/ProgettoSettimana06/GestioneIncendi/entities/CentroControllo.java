package ProgettoSettimana06.GestioneIncendi.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CentroControllo implements Subscriber {// Subscriber di Installazione
	private int id;
	private String messaggioAlPersonale;

	public CentroControllo(int id) {

		this.id = id;
	}

	@Override
	public void receiveUpdate(int id, String latitude, String longitude, int smokeLevel) {
		// TODO Auto-generated method stub

	}
}
