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
	public void cadastrarLivro(Livro livro) {

		livros.add(livro);

		System.out.println("Livro cadastrado com sucesso!");

	}

	// Cadastra um novo leitor na biblioteca.
	public void cadastrarLeitor(Leitor leitor) {

		leitores.add(leitor);

		System.out.println("Leitor cadastrado com sucesso!");
	}

	// Realiza um empréstimo de livro.
	public void realizarEmprestimo(Leitor leitor, Livro livro) {

		// Verifica se os objetos foram informados.
		if (leitor == null || livro == null) {
			System.out.println("Leitor ou livro invalido!");
			return;
		}

		// Verifica se o leitor está cadastrado.
		if (!leitores.contains(leitor)) {
			System.out.println("Leitor não cadastrado!");
			return;
		}

		// Verifica se o livro está cadastrado.
		if (!livros.contains(livro)) {
			System.out.println("Livro não cadastrado!!");
			return;
		}

		// Verifica se o livro está disponível.
		if (!livro.isDisponivel()) {
			System.out.println("Livro indisponível!");
			return;
		}

		// Conta os empréstimos ativos do leitor.
		int emprestimosAtivos = 0;

		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getLeitor().getCpf().equals(leitor.getCpf()) && !emprestimo.isDevolvido()) {

				emprestimosAtivos++;
			}
		}

		// Verifica o limite de dois empréstimos simultâneos.
		if (emprestimosAtivos >= 2) {
			System.out.println("Limite de empréstimos atingido!");
			return;
		}

		// Cria e registra o novo empréstimo.
		Emprestimo novoEmprestimo = new Emprestimo(leitor, livro);

		emprestimos.add(novoEmprestimo);

		// Torna o livro indisponível.
		livro.setDisponivel(false);

		System.out.println("Empréstimo realizado com sucesso!");
	}

	// Realiza a devolução de um livro pelo seu código.
	public void devolverLivro(String codigoLivro) {

		// Verifica se o código informado é inválido ou está vazio.
		if (codigoLivro == null || codigoLivro.isBlank()) {
			System.out.println("Código do livro inválido!");
			return;
		}

		// Percorre todos os empréstimos registrados na biblioteca.
		for (Emprestimo emprestimo : emprestimos) {

			// Verifica se o código corresponde ao livro e se ele ainda não foi devolvido.
			if (emprestimo.getLivro().getCodigo().equals(codigoLivro) && !emprestimo.isDevolvido()) {

				// Chama o método responsável por concluir a devolução.
				emprestimo.devolverLivro();
				return;
			}
		}

		// Informa quando não existe empréstimo ativo para o código informado.
		System.out.println("Nenhum empréstimo ativo encontrado para esse livro!");
	}

	// Exibe todos os livros cadastrados na biblioteca.
	public void listarLivros() {

		// Verifica se a lista de livros está vazia.
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}

		// Percorre a lista e exibe os dados de cada livro.
		for (Livro livro : livros) {
			System.out.println("--------------------");
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Código: " + livro.getCodigo());

			// Informa se o livro está disponível para empréstimo.
			if (livro.isDisponivel()) {
				System.out.println("Disponibilidade: Disponível");
			} else {
				System.out.println("Disponibilidade: Emprestado");
			}
		}
		System.out.println("--------------------");
	}

	// Exibe todos os leitores cadastrados na biblioteca.
	public void listarLeitores() {

		// Verifica se existe algum leitor cadastrado.
		if (leitores.isEmpty()) {
			System.out.println("Nenhum leitor cadastrado!");
			return;
		}

		// Percorre a lista de leitores.
		for (Leitor leitor : leitores) {
			System.out.println("--------------------");

			// Exibe os dados do leitor utilizando o método sobrescrito.
			leitor.exibirDados();
		}

		System.out.println("--------------------");
	}

	// Exibe todos os empréstimos registrados na biblioteca.
	public void listarEmprestimos() {

		// Verifica se existe algum empréstimo registrado.
		if (emprestimos.isEmpty()) {
			System.out.println("Nenhum empréstimo registrado!");
			return;
		}

		// Percorre todos os empréstimos da biblioteca.
		for (Emprestimo emprestimo : emprestimos) {
			System.out.println("--------------------");

			// Exibe o nome do leitor e o título do livro.
			System.out.println("Leitor: " + emprestimo.getLeitor().getNome());
			System.out.println("Livro: " + emprestimo.getLivro().getTitulo());

			// Exibe a situação atual do empréstimo.
			if (emprestimo.isDevolvido()) {
				System.out.println("Situação: Devolvido");
			} else {
				System.out.println("Situação: Em andamento");
			}

			// Exibe a data prevista para devolução.
			System.out.println("Data de devolução: " + emprestimo.getDataDevolucao().getTime());
		}

		System.out.println("--------------------");
	}

}
