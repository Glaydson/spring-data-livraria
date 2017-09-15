package br.edu.unichristus.springdatalivraria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unichristus.springdatalivraria.entidades.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
