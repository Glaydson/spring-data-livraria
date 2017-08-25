package br.edu.unichristus.springdatalivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    public void gravar(Livro livro) {
        this.repo.save(livro);
    }
}

