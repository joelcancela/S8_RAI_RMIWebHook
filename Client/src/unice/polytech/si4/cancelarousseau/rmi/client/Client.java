package unice.polytech.si4.cancelarousseau.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class Client extends UnicastRemoteObject implements IClient {
	private String name = "Anonymous";

	protected Client() throws RemoteException {
	}

	@Override
	public void displayMessage(String message) throws RemoteException {
		System.out.printf("Message reçu: "+message+ "\n#> ");
	}

	@Override
	public String getClientName() throws RemoteException {
		return name;
	}

	public void setCoolName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Client client = (Client) o;
		return Objects.equals(name, client.name);
	}

	@Override
	public int hashCode() {

		return Objects.hash(super.hashCode(), name);
	}
}
