package ProgettoSettimana06.GestioneIncendi.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CentroControllo implements Subscriber {// Subscriber di Installazione
	private int id;
	private String messaggioAlPersonale;
	private List<Installazione> installazioniAssociate = new ArrayList<>();

	public CentroControllo(int id) {

		this.id = id;
	}


	@Override
	@Deprecated
	public void receiveUpdateFromSonda(int idSonda, String latitude, String longitude, int smokeLevel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receiveUpdateFromInstallazione(int idInstallazione, int idSonda, String latitude, String longitude,
			int smokeLevel, String messaggio) {
		System.err.println("Id Installazione = " + idInstallazione);
		System.err.println("http://host/alarm?=idSonda=[" + idSonda + "]&lat=[" + latitude + "]&lon=[" + longitude
				+ "]&smokelevel=[" + smokeLevel + "]");


	}




	@Override
	public String toString() {
		return "CentroControllo [id=" + id + ", installazioniAssociate=" + installazioniAssociate + "]";
	}

}
