package br.edu.unichristus.springdatalivraria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataLivrariaApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Override
	public void run(String... args) {
		Livro livro = new Livro("Java Como Programar", new Date(), 250, new BigDecimal("15.00"));
		this.servicoLivros.gravar(livro);
		
		// Buscando um livro pelo seu ID
		Livro livro1 = this.servicoLivros.buscarPeloID(7L);
		System.out.println(livro1);
		
		// Buscando vários livros pelos seus IDs (1, 3 e 5)
		List<Livro> livros2 = this.servicoLivros.buscarPelosIDs(new ArrayList<Long>() {{
		    add(1L);
		    add(3L);
		    add(5L);
		}});
		for (Livro l : livros2) {
		    System.out.println(l);
		}


	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplication.class, args);
	}
}
