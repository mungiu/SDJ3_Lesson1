package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import SharedInterfaces.IServerProxy;

public class StartServer {
    public static void main(String[] args) {
	IServerProxy iServerProxy = new ServerController();
	LocateRegistry.createRegistry(1099);
	Naming.rebind("iServerProxy", iServerProxy);

	System.out.println("Server started...");
    }
}
