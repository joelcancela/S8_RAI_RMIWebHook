package unice.polytech.si4.cancelarousseau.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
	void displayMessage(String message) throws RemoteException;
	String getClientName() throws RemoteException;
}
