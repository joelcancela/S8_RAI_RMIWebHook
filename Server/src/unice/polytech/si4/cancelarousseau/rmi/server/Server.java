package unice.polytech.si4.cancelarousseau.rmi.server;

import unice.polytech.si4.cancelarousseau.rmi.client.IClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Server extends UnicastRemoteObject implements IServer {

	private Set<IClient> clients = new HashSet<>();

	public Server() throws RemoteException {
	}

	@Override
	public boolean subscribe(IClient client) throws RemoteException {
		if (clients.add(client)) {
			System.out.printf(client.getClientName() + " s'est abonné \n#> ");
		}
		return true;
	}

	@Override
	public boolean unsubscribe(IClient client) throws RemoteException {
		if (clients.remove(client)) {
			System.out.printf(client.getClientName() + " s'est désinscrit \n#> ");
		}
		return true;
	}

	public void sendMessageToSubscribers(String message) {
		clients.stream().forEach(client -> {
			try {
				client.displayMessage(message);
				System.out.println("Envoyé: " + message + " à " + client.getClientName());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}

	public void sendLoto() {
		Random random = new Random();
		for(int i=0; i<6;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int rand = random.nextInt(51);
			if(i==5){
				sendMessageToSubscribers("Et le numéro complémentaire le "+rand);
			}else{
				sendMessageToSubscribers("Le "+rand);
			}
		}
	}
}
