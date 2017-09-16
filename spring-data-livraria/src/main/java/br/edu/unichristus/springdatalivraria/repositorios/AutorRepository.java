package br.edu.unichristus.springdatalivraria.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.springdatalivraria.entidades.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	// Buscar os autores de um livro
	public List<Autor> findByLivrosTitulo(String nomeLivro);

}
