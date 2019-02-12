package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import SharedInterfaces.IClientProxy;
import SharedInterfaces.IServerProxy;
import SharedInterfaces.Observer;

public class ClientController implements IClientProxy {
    private IServerProxy iServerProxy;

    public ClientController() throws RemoteException, MalformedURLException, NotBoundException {
	UnicastRemoteObject.exportObject(this, 0);
	iServerProxy = (IServerProxy) Naming.lookup("rmi://localhost:1099/iServerController");
    }

    @Override
    public void notify(SharedInterfaces.Observable obs, String arg) throws RemoteException {
	System.out.println(arg);
    }

    @Override
    public void sendMessageToClient(String message) {
	System.out.println(message);
    }

    public void clientInput(String message) throws RemoteException {
	iServerProxy.sendMessageToServer(message);
    };

    public void registerClientOnServer() {
	try {
	    iServerProxy.addObserver(this);
	} catch (RemoteException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
