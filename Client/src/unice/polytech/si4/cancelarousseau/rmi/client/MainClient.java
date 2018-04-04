package unice.polytech.si4.cancelarousseau.rmi.client;

import unice.polytech.si4.cancelarousseau.rmi.server.IServer;

import java.rmi.Naming;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {

        try {
	        String host = args[0];
	        String url = "rmi://"+host+"/cancelarousseau";
            // Fetch remote service
            IServer stub = (IServer) Naming.lookup(url);
            System.out.println("[INFO] Connected @ " + url);
            // Register client
	        Client client = new Client();
	        client.setCoolName(args[1]); //TODO with prompt;
	        stub.subscribe(client);
            System.out.printf("###>");
	        Scanner scan = new Scanner(System.in);
	        String prompt = scan.nextLine();
	        while (true) {
		        switch (prompt) {
			        case "quit":
				        stub.unsubscribe(client);
				        break;
			        default:
				        break;
		        }
	        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERR] Remote connection failed... " + e.getMessage());
            System.exit(1);
        }
    }
}
