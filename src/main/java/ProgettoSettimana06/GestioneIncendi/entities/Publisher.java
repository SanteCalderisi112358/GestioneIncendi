package ProgettoSettimana06.GestioneIncendi.entities;

public abstract class Publisher {

	abstract public void addSubscriber(Subscriber subscriber);

	abstract public void removeSubscriber();

	abstract public void makeAnnouncment();
}
