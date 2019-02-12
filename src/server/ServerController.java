package server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import SharedInterfaces.IServerProxy;

public class ServerController implements IServerProxy {

    public ServerController() {
	try {
	    UnicastRemoteObject.exportObject(this, 0);
	} catch (RemoteException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public void sendMessageToServer(String message) {
	System.out.println("Received message: " + message);
	try {
	    this.notifyObservers(message);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    System.out.println("Something went wrong in the server controller");
	}
    }
    
    
}
