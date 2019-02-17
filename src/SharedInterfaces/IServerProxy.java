package SharedInterfaces;

import java.rmi.RemoteException;

public interface IServerProxy extends Observable<String> {
    void sendMessageToServer(String message) throws RemoteException;
}
