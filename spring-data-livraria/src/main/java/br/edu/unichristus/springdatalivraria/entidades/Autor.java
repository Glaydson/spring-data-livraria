package br.edu.unichristus.springdatalivraria.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AUTOR")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTOR_ID")
	private Long autorID;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "PAIS")
	private String pais;

	// Autor é o proprietário da relação many to many
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TB_AUTORES_LIVROS")
	private List<Livro> livros;

	// GETS E SETS, CONSTRUTOR, MÉTODO toString
	public Autor() {

	}

	public Autor(String nome, String pais, List<Livro> livros) {
		super();
		this.nome = nome;
		this.pais = pais;
		this.livros = livros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Long getAutorID() {
		return autorID;
	}

	@Override
	public String toString() {
		return "Autor [autorID=" + autorID + ", nome=" + nome + ", pais=" + pais + ", livros=" + livros + "]";
	}

}
