package biblioteca;

import java.util.ArrayList;

//Classe responsável pelo gerenciamento da biblioteca.
public class Biblioteca {

	// Define o limite máximo de empréstimos ativos por leitor.
	private static final int LIMITE_EMPRESTIMOS = 2;

	// Define o prazo de devolução dos livros em dias.
	public static final int PRAZO_DEVOLUCAO = 10;

	// Lista que armazena os livros.
	private ArrayList<Livro> livros;

	// Lista que armazena os leitores.
	private ArrayList<Leitor> leitores;

	// Lista que armazena os empréstimos.
	private ArrayList<Emprestimo> emprestimos;

	// Lista responsável por armazenar os funcionários cadastrados.
	private ArrayList<Funcionario> funcionarios;

	// Construtor responsável por inicializar as listas.
	public Biblioteca() {
		livros = new ArrayList<>();
		leitores = new ArrayList<>();
		emprestimos = new ArrayList<>();
		funcionarios = new ArrayList<>();

	}

	// Cadastra um livro após verificar se os dados são válidos.
	public void cadastrarLivro(Livro livro) {

		// Verifica se o objeto recebido é válido.
		if (livro == null) {
			System.out.println("Livro inválido!");
			return;
		}

		// Impede o cadastro de livros sem título, autor ou código.
		if (livro.getTitulo().isBlank() || livro.getAutor().isBlank() || livro.getCodigo().isBlank()) {
			System.out.println("Preencha todos os dados do livro!");
			return;
		}

		// Verifica se já existe um livro com o mesmo código.
		for (Livro cadastrado : livros) {
			if (cadastrado.getCodigo().equalsIgnoreCase(livro.getCodigo())) {
				System.out.println("Já existe um livro com esse código!");
				return;
			}
		}

		// Se passou por todas as verificações, adiciona o livro.
		livros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}

	// Cadastra um leitor após verificar se os dados são válidos.
	public void cadastrarLeitor(Leitor leitor) {

		// Verifica se o objeto recebido é válido.
		if (leitor == null) {
			System.out.println("Leitor inválido!");
			return;
		}

		// Impede o cadastro sem nome ou CPF.
		if (leitor.getNome().isBlank() || leitor.getCpf().isBlank()) {
			System.out.println("Preencha todos os dados do leitor!");
			return;
		}

		// Verifica se já existe um leitor com o mesmo CPF.
		for (Leitor cadastrado : leitores) {
			if (cadastrado.getCpf().equals(leitor.getCpf())) {
				System.out.println("Já existe um leitor com esse CPF!");
				return;
			}
		}

		// Se passou pelas verificações, adiciona o leitor.
		leitores.add(leitor);
		System.out.println("Leitor cadastrado com sucesso!");
	}

	// Cadastra um funcionário no sistema.
	public void cadastrarFuncionario(Funcionario funcionario) {

		// Verifica se o funcionário recebido é válido.
		if (funcionario == null) {
			System.out.println("Funcionário inválido!");
			return;
		}

		// Verifica se os dados obrigatórios foram preenchidos.
		if (funcionario.getNome().isBlank() || funcionario.getCpf().isBlank() || funcionario.getMatricula().isBlank()
				|| funcionario.getCargo().isBlank()) {
			System.out.println("Preencha todos os dados do funcionário!");
			return;
		}

		// Impede o cadastro de funcionários com CPF repetido.
		for (Funcionario cadastrado : funcionarios) {
			if (cadastrado.getCpf().equals(funcionario.getCpf())) {
				System.out.println("Já existe um funcionário com esse CPF!");
				return;
			}
		}

		// Armazena o funcionário na lista.
		funcionarios.add(funcionario);
		System.out.println("Funcionário cadastrado com sucesso!");
	}

	// Busca um leitor pelo CPF e retorna o objeto cadastrado.
	public Leitor buscarLeitorPorCpf(String cpf) {
		if (cpf == null || cpf.isBlank()) {
			return null;
		}

		for (Leitor leitor : leitores) {
			if (leitor.getCpf().equals(cpf)) {
				return leitor;
			}
		}

		return null;
	}

	// Busca um livro pelo código utilizando a interface Identificavel.
	public Livro buscarLivroPorCodigo(String codigo) {

		// Verifica se o código informado é válido.
		if (codigo == null || codigo.isBlank()) {
			return null;
		}

		// Percorre os livros cadastrados.
		for (Livro livro : livros) {

			// Utiliza uma referência do tipo Identificavel.
			Identificavel identificavel = livro;

			// Compara a identificação do livro com o código informado.
			if (identificavel.getIdentificacao().equalsIgnoreCase(codigo)) {
				return livro;
			}
		}

		// Retorna null caso não encontre o livro.
		return null;
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

		// Verifica se o leitor atingiu o limite de empréstimos ativos.
		if (emprestimosAtivos >= LIMITE_EMPRESTIMOS) {
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

	// Lista somente os livros que estão disponíveis para empréstimo.
	public void listarLivros(boolean somenteDisponiveis) {

		// Percorre todos os livros cadastrados.
		for (Livro livro : livros) {

			// Verifica se devemos mostrar apenas os disponíveis.
			if (!somenteDisponiveis || livro.isDisponivel()) {
				System.out.println("--------------------");
				System.out.println("Título: " + livro.getTitulo());
				System.out.println("Autor: " + livro.getAutor());
				System.out.println("Código: " + livro.getCodigo());
			}
		}
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

			// Armazena o objeto Leitor em uma referência do tipo Pessoa.
			Pessoa pessoa = leitor;

			// Chama o método usando a referência genérica.
			exibirDadosPessoa(pessoa);
		}

		System.out.println("--------------------");
	}

	// Lista todos os leitores e funcionários cadastrados.
	public void listarPessoas() {

		// Verifica se não existem pessoas cadastradas.
		if (leitores.isEmpty() && funcionarios.isEmpty()) {
			System.out.println("Nenhuma pessoa cadastrada!");
			return;
		}

		// Percorre os leitores utilizando referências do tipo Pessoa.
		for (Leitor leitor : leitores) {
			Pessoa pessoa = leitor;

			System.out.println("--------------------");
			pessoa.exibirDados();
			System.out.println("Tipo: Leitor");
		}

		// Percorre os funcionários utilizando referências do tipo Pessoa.
		for (Funcionario funcionario : funcionarios) {
			Pessoa pessoa = funcionario;

			System.out.println("--------------------");
			pessoa.exibirDados();
			System.out.println("Tipo: Funcionário");
		}

		System.out.println("--------------------");
	}

	// Demonstra o polimorfismo utilizando referências do tipo Pessoa.
	public void exibirDadosPessoa(Pessoa pessoa) {

		// Verifica se foi recebida uma pessoa válida.
		if (pessoa == null) {
			System.out.println("Pessoa não encontrada!");
			return;
		}

		// Executa a versão de exibirDados() correspondente ao objeto recebido.
		pessoa.exibirDados();
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
