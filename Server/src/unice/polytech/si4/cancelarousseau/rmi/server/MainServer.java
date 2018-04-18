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
			System.out.println("Enregistrement en cours de l'objet serveur avec l'url : " + url + " ...");
			Naming.rebind(url, server);
			System.out.println("Serveur lancé");
			System.out.printf("#> ");
			Scanner scan = new Scanner(System.in);
			String prompt = scan.nextLine();
			String cmd = "", msg;
			while (true) {
				try {
					cmd = prompt.split(" ")[0];
					msg = prompt.split(" ")[1];
				} catch (ArrayIndexOutOfBoundsException e) {
					msg = "";
				}
				switch (cmd) {
					case "send":
						server.sendMessageToSubscribers(msg);
						break;
					case "loto":
						server.sendLoto();
					case "help":
						System.out.println("Usage: send <message> | loto | help");
						break;
					default:
						System.out.println("Tapez \"help\" pour afficher les commandes possibles");
						break;
				}
				System.out.printf("#> ");
				prompt = scan.nextLine();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
