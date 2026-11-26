package biblioteca;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// Cria o objeto responsável pelo funcionamento da biblioteca.
		Biblioteca biblioteca = new Biblioteca();

		// Permite receber informações digitadas pelo usuário.
		Scanner scanner = new Scanner(System.in);

		int opcao = 0;

		// Mantém o menu funcionando até o usuário escolher sair.
		while (opcao != 8) {
			System.out.println("\n===== BIBLIOTECA FÁCIL =====");
			System.out.println("1 - Cadastrar livro");
			System.out.println("2 - Cadastrar leitor");
			System.out.println("3 - Realizar empréstimo");
			System.out.println("4 - Devolver livro");
			System.out.println("5 - Listar livros");
			System.out.println("6 - Listar leitores");
			System.out.println("7 - Listar empréstimos");
			System.out.println("8 - Sair");
			System.out.print("Escolha uma opção: ");

			// Lê a opção digitada pelo usuário.
			String entrada = scanner.nextLine();

			try {
				opcao = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				opcao = 0;
			}

			// Verifica a opção escolhida.
			switch (opcao) {

			case 8:
				System.out.println("Encerrando o sistema...");
				break;

			case 0:
				System.out.println("Opção inválida!");
				break;

			case 1:
				// Solicita os dados necessários para cadastrar um livro.
				System.out.print("Digite o título do livro: ");
				String titulo = scanner.nextLine();

				System.out.print("Digite o autor do livro: ");
				String autor = scanner.nextLine();

				System.out.print("Digite o código do livro: ");
				String codigo = scanner.nextLine();

				// Cria um objeto Livro com os dados informados.
				Livro livro = new Livro(titulo, autor, codigo);

				// Envia o livro para a biblioteca realizar o cadastro.
				biblioteca.cadastrarLivro(livro);
				break;

			case 2:
				// Solicita os dados do leitor.
				System.out.print("Digite o nome do leitor: ");
				String nome = scanner.nextLine();

				System.out.print("Digite o CPF do leitor: ");
				String cpf = scanner.nextLine();

				// Cria um novo objeto Leitor.
				Leitor leitor = new Leitor(nome, cpf);

				// Cadastra o leitor na biblioteca.
				biblioteca.cadastrarLeitor(leitor);
				break;

			case 5:
				// Chama o método que exibe os livros cadastrados.
				biblioteca.listarLivros();
				break;

			case 6:
				// Chama o método que exibe os leitores cadastrados.
				biblioteca.listarLeitores();
				break;

			default:
				System.out.println("Opção inválida!");
				break;

			}
		}
		scanner.close();
	}

}
