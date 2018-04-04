package unice.polytech.si4.cancelarousseau.rmi.server;

import unice.polytech.si4.cancelarousseau.rmi.client.IClient;

import java.rmi.Remote;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public interface IServer extends Remote {

	boolean subscribe(IClient client);
	boolean unsubscribe(IClient client);

}
