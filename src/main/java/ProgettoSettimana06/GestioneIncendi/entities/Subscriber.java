package ProgettoSettimana06.GestioneIncendi.entities;

public interface Subscriber {
	public void receiveUpdateFromSonda(int idSonda, String latitude, String longitude, int smokeLevel);

	public void receiveUpdateFromInstallazione(int idInstallazione, int idSonda, String latitude, String longitude,
			int smokeLevel, String messaggio);
}

