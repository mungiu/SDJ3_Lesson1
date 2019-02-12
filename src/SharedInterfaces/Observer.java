package SharedInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {
    void notify(Observable obs, String arg) throws RemoteException;
}
