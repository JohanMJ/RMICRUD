package cliente;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import model.Livro;
import servidor.IBiblioteca;

public class ClientBiblioteca {

	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		 Registry registry = LocateRegistry.getRegistry();
	
		 Livro l = new Livro(20, "20", "10", -1);
		 IBiblioteca stub = (IBiblioteca) registry.lookup("Biblioteca");
		 
		 
		 /*
		 stub.listarLivros();
		 
		 stub.adicionarLivro(l, 1);
		 
		 stub.listarLivros();
		 
		 stub.emprestarLivro(20, 1);
		 
		 stub.excluirLivro(20, 1);
		 
		 */
		 
		 stub.devolverLivro(20, 1);
		 
		 
			
				
	}
}
