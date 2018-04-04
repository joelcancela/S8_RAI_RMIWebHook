package unice.polytech.si4.cancelarousseau.rmi.server;

import unice.polytech.si4.cancelarousseau.rmi.client.IClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Server extends UnicastRemoteObject implements IServer {

	private List<IClient> clients = new ArrayList<>();

	public Server() throws RemoteException {
	}

	@Override
	public boolean subscribe(IClient client) throws RemoteException{
		clients.add(client);
		return true;
	}

	@Override
	public boolean unsubscribe(IClient client)throws RemoteException {
		clients.remove(client);
		return true;
	}

	public void sendMessageToSubscribers(String message){
		clients.stream().forEach(client -> {
			try {
				client.displayMessage(message);
				System.out.println("Sent "+message+" to "+client.getClientName());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
