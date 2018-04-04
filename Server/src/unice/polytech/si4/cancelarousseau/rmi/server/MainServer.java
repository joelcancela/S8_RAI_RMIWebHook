package unice.polytech.si4.cancelarousseau.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class MainServer {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);

			Server server = new Server();

			String url = "rmi://localhost/cancelarousseau";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, server);
			System.out.println("Serveur lancé");
			System.out.println("Entrez vos commandes : send <msg>");
			Scanner scan = new Scanner(System.in);
			String prompt = scan.nextLine();
			String cmd = prompt.split(" ")[0];
			String msg = prompt.split(" ")[1];
			while (true) {
				switch (cmd) {
					case "send":
						server.sendMessageToSubscribers(msg);
						prompt = scan.nextLine();
						cmd = prompt.split(" ")[0];
						msg = prompt.split(" ")[1];
						break;
					default:
						break;
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
