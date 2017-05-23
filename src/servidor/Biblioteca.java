package servidor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import model.Livro;
import model.Usuario;

public class Biblioteca implements IBiblioteca {

	List<Usuario> usuarios;
	List<Livro> livros;

	Usuario u = new Usuario("123", 1, "123", true);

	Livro l = new Livro(9, "21", "22", -1);

	public Biblioteca() {
		usuarios = new ArrayList<Usuario>();
		livros = new ArrayList<Livro>();

		usuarios.add(u);
		livros.add(l);
	}

	@Override
	public synchronized boolean adicionarLivro(Livro livro, Integer idUsuario) throws RemoteException {
		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == livro.getIdLivro()) {
				return false;
			}

		}

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getIdUsuario() == idUsuario) {
				if (usuarios.get(i).isAdm()) {
					livros.add(livro);
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public synchronized boolean excluirLivro(int idLivro, int idUsuario) throws RemoteException {

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == idLivro) {
				while (livros.get(i).getIdUsuario() != -1) {
					try {
						System.out
								.println("Livro " + livros.get(i).getIdLivro() + " emprestado...impossível removê-lo");
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				for (int y = 0; y < usuarios.size(); y++) {
					if (usuarios.get(y).getIdUsuario() == idUsuario) {
						if (usuarios.get(y).isAdm()) {
							livros.remove(i);
							notify();
							System.out.println("Removido com sucesso");
							return true;
						}
					}
				}

			}
		}
		return false;
	}

	@Override
	public void listarLivros() throws RemoteException {
		for (int i = 0; i < livros.size(); i++) {
			System.out.println(livros.get(i).toString());
		}
	}

	@Override
	public synchronized boolean emprestarLivro(int idLivros, int idUsuario) throws RemoteException {
		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == idLivros) {
				for (int y = 0; y < usuarios.size(); y++) {
					if (usuarios.get(y).getIdUsuario() == idUsuario) {
						while (livros.get(i).getIdUsuario() != -1) {
							try {
								System.out.println("Livro " + livros.get(i).getIdLivro() + " indisponível...");
								wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						livros.get(i).setIdUsuario(idUsuario);
						System.out.println("Livro " + livros.get(i).getIdLivro() + " foi emprestado");
						notify();
						return true;
					}

				}
			}
		}
		return false;

	}

	@Override
	public synchronized boolean devolverLivro(int idLivros, int idUsuario) throws RemoteException {
		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == idLivros) {
				for (int y = 0; y < usuarios.size(); y++) {
					if (usuarios.get(y).getIdUsuario() == idUsuario) {
						while (livros.get(i).getIdUsuario() == -1) {
							try {
								System.out.println("Livro " + livros.get(i).getIdLivro() + " disponível...");
								wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						livros.get(i).setIdUsuario(-1);
						System.out.println("Livro " + livros.get(i).getIdLivro() + " foi devolvido");
						notify();
						return true;
					}

				}
			}
		}
		return false;
	}

}
