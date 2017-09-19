package br.edu.unichristus.springdatalivraria;

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
public class SpringDataLivrariaConsultas implements CommandLineRunner {

	@Autowired
	private LivroService servicoLivros;

	@Autowired
	private EditoraService servicoEditoras;

	@Autowired
	private AutorService servicoAutores;

	@Override
	public void run(String... args) {
		// Buscando os livros da editora Campus
		List<Livro> livrosCampus = this.servicoLivros.buscarPeloNomeEditora("Campus");
		livrosCampus.forEach(l -> System.out.println(l));

		// Buscando os livros do autor Paul Deitel
		List<Livro> livrosDeitel = this.servicoLivros.buscarPeloNomeAutor("Paul Deitel");
		livrosDeitel.forEach(l -> System.out.println(l));

		// Buscando os autores do livro Java Como Programar
		List<Autor> autoresJava = this.servicoAutores.buscarAutoresLivro("Java Como Programar");
		autoresJava.forEach(a -> System.out.println(a));

		// Buscando os livros dos autores da Inglaterra
		List<Livro> livrosInglaterra = this.servicoLivros.buscarLivrosPais("Inglaterra");
		livrosInglaterra.forEach(l -> System.out.println(l));

		// Tentando inserir uma editora com o nome já existente
		try {
			Editora e = new Editora("Campus", "Rio de Janeiro", 1908);
			this.servicoEditoras.salvar(e);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		// Tentando remover um autor que não existe
		try {
			this.servicoAutores.remover(10L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaConsultas.class, args);
	}
}
