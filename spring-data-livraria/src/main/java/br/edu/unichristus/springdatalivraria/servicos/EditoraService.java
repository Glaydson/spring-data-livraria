package br.edu.unichristus.springdatalivraria.servicos;

import javax.persistence.PersistenceException;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.unichristus.springdatalivraria.entidades.Editora;
import br.edu.unichristus.springdatalivraria.repositorios.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repo;

	public void salvar(Editora e) throws Exception {
		try {
			this.repo.save(e);
		} catch (Exception pe) {
			// Relança para configurar/mudar a mensagem de erro
			throw new Exception("Editora " + e.getNome() + " já existente!");
		}
	}

	public Editora buscarPeloNome(String nomeEditora) {
		System.out.println("Buscando a editora " + nomeEditora);
		return this.repo.findByNome(nomeEditora);
	}

}
