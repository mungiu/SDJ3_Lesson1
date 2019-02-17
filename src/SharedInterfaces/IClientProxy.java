package SharedInterfaces;

import java.rmi.RemoteException;

public interface IClientProxy extends Observer<String> {
    void sendMessageToClient(String message) throws RemoteException;
}
