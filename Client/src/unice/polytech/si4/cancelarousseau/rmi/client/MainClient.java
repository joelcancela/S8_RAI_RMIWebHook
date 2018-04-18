package unice.polytech.si4.cancelarousseau.rmi.client;

import unice.polytech.si4.cancelarousseau.rmi.server.IServer;

import java.rmi.Naming;
import java.util.Scanner;

import static java.lang.System.exit;

public class MainClient {

    public static void main(String[] args) {
        try {
	        Scanner scan = new Scanner(System.in);
	        System.out.printf("IP du serveur RMI: ");
	        String host = scan.nextLine();
	        String url = "rmi://"+host+"/cancelarousseau";
            // Fetch remote service
            IServer stub = (IServer) Naming.lookup(url);
            System.out.println("Connecté au serveur " + url);
            // Register client
	        Client client = new Client();
	        System.out.printf("Choisissez un identifiant : ");
	        String nickname = scan.nextLine();
	        client.setCoolName(nickname);
	        stub.subscribe(client);
	        System.out.println("Vous avez souscrit auprès du serveur "+host+ " en tant que "+nickname);
	        System.out.printf("#> ");
	        String prompt = scan.nextLine();
	        while (true) {
		        switch (prompt) {
			        case "sub":
			        	stub.subscribe(client);
						break;
			        case "unsub":
				        stub.unsubscribe(client);
				        break;
			        case "exit":
			        	stub.unsubscribe(client);
			        	exit(0);
			        case "help":
				        System.out.println("Usage: sub | unsub | exit | help");
				        break;
			        default:
				        System.out.println("Tapez \"help\" pour afficher les commandes possibles");
				        break;
		        }
		        System.out.printf("#> ");
		        prompt = scan.nextLine();
	        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERR] Remote connection failed... " + e.getMessage());
            exit(1);
        }
    }
}
