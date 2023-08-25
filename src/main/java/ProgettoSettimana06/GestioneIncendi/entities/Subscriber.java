package ProgettoSettimana06.GestioneIncendi.entities;

public interface Subscriber {
	public void receiveUpdate(int id, String latitude, String longitude, int smokeLevel);
}
