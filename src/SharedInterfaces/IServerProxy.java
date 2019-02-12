package SharedInterfaces;

import java.rmi.RemoteException;

public interface IServerProxy extends Observable {
    void sendMessageToServer(String message) throws RemoteException;
}
