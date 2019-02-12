package SharedInterfaces;

import java.rmi.RemoteException;

public interface IClientProxy extends Observer {
    void sendMessageToClient(String message) throws RemoteException;
}
