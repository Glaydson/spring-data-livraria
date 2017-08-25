package br.edu.unichristus.springdatalivraria;

import java.math.BigDecimal;
import java.util.Date;

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
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplication.class, args);
	}
}
