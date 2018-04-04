package unice.polytech.si4.cancelarousseau.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements IClient {
	private String name = "Anonymous";

	protected Client() throws RemoteException {
	}

	@Override
	public void displayMessage(String message) throws RemoteException {
		System.out.println(message);
	}

	@Override
	public String getClientName() throws RemoteException {
		return name;
	}

	public void setCoolName(String name) {
		this.name = name;
	}
}
