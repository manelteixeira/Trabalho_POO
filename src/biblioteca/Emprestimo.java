package biblioteca;

import java.util.Calendar;

//Classe responsável por representar os empréstimos de livros.
public class Emprestimo {

	// Leitor que realizou o empréstimo.
	private Leitor leitor;

	// Livro que foi emprestado.
	private Livro livro;

	// Data em que o empréstimo foi realizado.
	private Calendar dataEmprestimo;

	// Data prevista para a devolução.
	private Calendar dataDevolucao;

	// Informa se o livro já foi devolvido.
	private boolean devolvido;

	// Construtor que inicializa um novo empréstimo.
	public Emprestimo(Leitor leitor, Livro livro) {
		this.leitor = leitor;
		this.livro = livro;

		// Registra a data atual do empréstimo.
		this.dataEmprestimo = Calendar.getInstance();

		// Cria a data prevista para devolução.
		this.dataDevolucao = (Calendar) dataEmprestimo.clone();

		// Calcula a data de devolução usando o prazo definido na Biblioteca.
		this.dataDevolucao.add(Calendar.DAY_OF_MONTH, Biblioteca.PRAZO_DEVOLUCAO);

		// Todo empréstimo começa com o livro não devolvido.
		this.devolvido = false;
	}


	// Retorna o leitor responsável pelo empréstimo.
	public Leitor getLeitor() {
	    return leitor;
	}

	// Retorna o livro emprestado.
	public Livro getLivro() {
	    return livro;
	}

	// Retorna a data em que o empréstimo foi realizado.
	public Calendar getDataEmprestimo() {
	    return dataEmprestimo;
	}

	// Retorna a data prevista para devolução.
	public Calendar getDataDevolucao() {
	    return dataDevolucao;
	}

	// Verifica se o livro já foi devolvido.
	public boolean isDevolvido() {
	    return devolvido;
	}

	// Registra a devolução do livro.
	public void devolverLivro(){
		
		// Verifica se o livro ainda não foi devolvido.
		if(!devolvido) {
			
			devolvido = true;
			
			// Atualiza a disponibilidade do livro.
			livro.setDisponivel(true);
			
			System.out.println("Livro devolvido com sucesso!");
		} else {
			System.out.println("Livro ja foi devolvido.");
		}
		
	}

}
