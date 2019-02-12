package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import SharedInterfaces.IClientProxy;

public class StartClient {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
	String userInput;
	IClientProxy iClientProxy = new ClientController();
	Naming.rebind("iClientProxy", iClientProxy);
	((ClientController) iClientProxy).registerClientOnServer();
	
	System.out.println("Client started...");

	Scanner keyboard = new Scanner(System.in);

	while (true) {
	    userInput = keyboard.nextLine();
	    keyboard.close();
	    System.out.println(keyboard.nextLine());
	    ((ClientController) iClientProxy).clientInput(userInput);
	}
    }
}
