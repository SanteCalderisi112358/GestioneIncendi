package ProgettoSettimana06.GestioneIncendi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sonda extends Publisher { // Publisher
	private int id;
	private String latitude;
	private String longitude;
	private int smokeLevel;
	private Subscriber installazioneSubscriber;

	public Sonda(int id, String latitude, String longitude) {

		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public void addSubscriber(Subscriber subscriber) {
		this.installazioneSubscriber = subscriber;

	}

	@Override
	public void removeSubscriber() {
		this.installazioneSubscriber = null;

	}

	@Override
	public void makeAnnouncment() {
		this.installazioneSubscriber.receiveUpdate(id, latitude, longitude, smokeLevel);

	}

	@Override
	public String toString() {
		return "Sonda [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", smokeLevel=" + smokeLevel
				+ "]";
	}

}
