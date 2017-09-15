package br.edu.unichristus.springdatalivraria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.springdatalivraria.entidades.Livro;
import br.edu.unichristus.springdatalivraria.servicos.LivroService;

//@SpringBootApplication
public class SpringDataLivrariaApplication implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Override
	public void run(String... args) {
	//	Livro livro = new Livro("Java Como Programar", new Date(), 250, new BigDecimal("15.00"));
	//	this.servicoLivros.gravar(livro);
		
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
		
		// Alterar o título do livro com id = 1
		Livro livro3 = this.servicoLivros.buscarPeloID(1L);
		System.out.println(livro3);
		livro3.setTitulo("Pro Spring");
		this.servicoLivros.gravar(livro3);
		System.out.println(livro3);

		// Removendo dois livros
		this.servicoLivros.remover(1L);
		this.servicoLivros.remover(this.servicoLivros.buscarPeloID(2L));

		Livro livro5 = this.servicoLivros.buscarPeloTitulo("Guerra e Paz");
		System.out.println(livro5);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplication.class, args);
	}
}
