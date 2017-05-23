package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Livro;

//interface visivel ao cliente
public interface IBiblioteca extends Remote {

	public boolean adicionarLivro(Livro livro, Integer idUsuario) throws RemoteException;
	public boolean excluirLivro(int idLivro, int idUsuario) throws RemoteException;
	public void listarLivros() throws RemoteException;
	public boolean emprestarLivro(int idLivros, int idUsuario) throws RemoteException;
	public boolean devolverLivro (int idLivros, int idUsuario) throws RemoteException;
	
}
