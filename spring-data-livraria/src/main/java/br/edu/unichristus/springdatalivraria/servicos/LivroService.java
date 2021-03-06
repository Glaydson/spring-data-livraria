package br.edu.unichristus.springdatalivraria.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.springdatalivraria.entidades.Livro;
import br.edu.unichristus.springdatalivraria.repositorios.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    public void gravar(Livro livro) throws PersistenceException{
        this.repo.save(livro);
        System.out.println("LIVRO SALVO!");
    }
    
    public Livro buscarPeloID(long idLivro) {
        return this.repo.findOne(idLivro);
    }
    
    public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
        return this.repo.findAll(idsLivros);
    }
    
    public void remover(Long idLivro) {
        this.repo.delete(idLivro);
    }

    public void remover(Livro livro) {
        this.repo.delete(livro);
    }

    public Livro buscarPeloTitulo(String titulo) {
    	System.out.println("BUSCANDO UM LIVRO PELO TÍTULO");
        return this.repo.findByTitulo(titulo);
    }

    public List<Livro> buscarPeloNomeEditora(String nomeEditora) {
    	System.out.println("Buscando os livros da editora " + nomeEditora);
    	return this.repo.findByEditoraNome(nomeEditora);
    }
    
    public List<Livro> buscarPeloNomeAutor(String nomeAutor) {
    	System.out.println("Buscando os livros do autor " + nomeAutor);
    	return this.repo.findByAutoresNome(nomeAutor);
    }
    
    public List<Livro> buscarLivrosPais(String pais) {
    	System.out.println("Buscando os livros dos autores do país " + pais);
    	return this.repo.findByAutoresPais(pais);
    }

}

