package SharedInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface Observable extends Remote {
    List<Observer> observers = new ArrayList<>();

    default void addObserver(Observer obs) throws RemoteException {
	if (!observers.contains(obs))
	    observers.add(obs);
    }

    default void deleteObserver(Observer obs) throws RemoteException {
	observers.remove(obs);
    }

    default void notifyObservers(String arg) throws RemoteException {
	for (Observer observer : observers) {
	    observer.notify(this, arg);
	}
    }
}
