package servidor;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerBiblioteca {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Biblioteca h = new Biblioteca();
		
		
		IBiblioteca stub = (IBiblioteca) UnicastRemoteObject.exportObject(h, 0);
		
		Registry registry = LocateRegistry.getRegistry();
		
		registry.rebind("Biblioteca", stub);
	}
}
