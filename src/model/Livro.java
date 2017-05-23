package model;

import java.io.Serializable;

public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idLivro;
	private String titulo;
	private String anoPublicacao;
	private Integer idUsuario;

	public Livro(Integer idLivro, String titulo, String anoPublicacao, Integer idUsuario) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.idUsuario = idUsuario;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", anoPublicacao=" + anoPublicacao + ", idUsuario="
				+ idUsuario + "]";
	}
	
	

}
