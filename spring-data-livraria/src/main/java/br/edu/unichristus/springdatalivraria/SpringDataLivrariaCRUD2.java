package br.edu.unichristus.springdatalivraria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.springdatalivraria.entidades.Autor;
import br.edu.unichristus.springdatalivraria.entidades.Editora;
import br.edu.unichristus.springdatalivraria.entidades.Livro;
import br.edu.unichristus.springdatalivraria.servicos.AutorService;
import br.edu.unichristus.springdatalivraria.servicos.EditoraService;
import br.edu.unichristus.springdatalivraria.servicos.LivroService;

@SpringBootApplication
public class SpringDataLivrariaCRUD2 implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;
	
	@Autowired
	private EditoraService servicoEditoras;
	
	@Autowired
	private AutorService servicoAutores;

	@Override
	public void run(String... args) {
		// Incluindo uma nova editora
		Editora e = new Editora("Érica", "Rio de Janeiro", 1937);

		// Incluindo um novo livro. É preciso dizer qual é a editora
		Livro l = new Livro("Java em 30 dias", LocalDate.now(), 250, new BigDecimal("15.00"), e);

		// Configurando o autor do livro
		List<Livro> livrosJose = (new ArrayList<Livro>() {
			{
				add(l);
			}
		});

		// Incluindo um novo autor
		Autor a = new Autor("Antonio José", "Brasil", livrosJose);

		// SALVANDO AS ENTIDADES - OBSERVE A ORDEM
		this.servicoEditoras.salvar(e);
		this.servicoLivros.gravar(l);
		this.servicoAutores.salvar(a);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaCRUD2.class, args);
	}
}
