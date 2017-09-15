package br.edu.unichristus.springdatalivraria.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EDITORA")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EDITORA_ID")
	private Long editoraID;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "ANO_FUNDACAO")
	private int anoFundacao;

	@OneToMany(mappedBy = "editora")
	private List<Livro> livros;
	// CONSTRUTOR, GETTERS E SETTERS, MÉTODO toString

	public Editora(String nome, String cidade, int anoFundacao) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.anoFundacao = anoFundacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getAnoFundacao() {
		return anoFundacao;
	}

	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Long getEditoraID() {
		return editoraID;
	}

	@Override
	public String toString() {
		return "Editora [editoraID=" + editoraID + ", nome=" + nome + ", cidade=" + cidade + ", anoFundacao="
				+ anoFundacao + ", livros=" + livros + "]";
	}

}
