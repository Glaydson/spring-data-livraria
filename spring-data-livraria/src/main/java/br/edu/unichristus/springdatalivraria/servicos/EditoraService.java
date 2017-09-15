package br.edu.unichristus.springdatalivraria.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.springdatalivraria.entidades.Editora;
import br.edu.unichristus.springdatalivraria.repositorios.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public void salvar(Editora e) {
		this.repo.save(e);
	}

}
