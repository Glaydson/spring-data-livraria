package br.edu.unichristus.springdatalivraria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    public void gravar(Livro livro) {
        this.repo.save(livro);
    }
    
    public Livro buscarPeloID(long idLivro) {
        return this.repo.findOne(idLivro);
    }
    
    public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivros) {
        return this.repo.findAll(idsLivros);
    }


}

