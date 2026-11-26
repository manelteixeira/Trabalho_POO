package biblioteca;

import java.util.ArrayList;

//Classe responsável pelo gerenciamento da biblioteca.
public class Biblioteca {
	
	// Lista que armazena os livros.
	private ArrayList<Livro> livros;
	
	// Lista que armazena os leitores.
	private ArrayList<Leitor> leitores;
	
	// Lista que armazena os empréstimos.
	private ArrayList<Emprestimo> emprestimos;
	
	// Construtor responsável por inicializar as listas.
	public Biblioteca() {
		livros = new ArrayList<>();
		leitores = new ArrayList<>();
		emprestimos = new ArrayList<>();
		
	}
	
	// Cadastra um novo livro na biblioteca.
	public void cadastrarLivro (Livro livro) {
		
		livros.add(livro);
		
		System.out.println("Livro cadastrado com sucesso!");
		
	}
	
	// Cadastra um novo leitor na biblioteca.
	public void cadastrarLeitor (Leitor leitor) {
		
		leitores.add(leitor);
		
		System.out.println("Leitor cadastrado com sucesso!");
	}
	

}
