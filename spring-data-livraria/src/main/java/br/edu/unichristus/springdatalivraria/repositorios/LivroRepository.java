package br.edu.unichristus.springdatalivraria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.springdatalivraria.entidades.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	// Buscar livro pelo título
	public Livro findByTitulo(String titulo);
}
