package br.edu.unichristus.springdatalivraria.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.springdatalivraria.entidades.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	// Buscar livro pelo título
	public Livro findByTitulo(String titulo);
	
	// Buscar os livros de um autor pelo seu nome
	public List<Livro> findByAutoresNome(String nomeAutor);

	// Buscar os livros dos autores de um determinado país
	public List<Livro> findByAutoresPais(String pais);
	
	// Busca todos os livros de uma editora
	public List<Livro> findByEditoraNome(String nomeEditora);

}
