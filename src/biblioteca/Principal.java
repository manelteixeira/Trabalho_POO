
package biblioteca;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        // Cria o objeto responsável pelas operações da biblioteca.
        Biblioteca biblioteca = new Biblioteca();

        // Cria o Scanner para receber os dados digitados pelo usuário.
        Scanner scanner = new Scanner(System.in);

        // Controla a repetição do menu.
        int opcao = 0;

        // Mantém o sistema funcionando até o usuário escolher sair.
        while (opcao != 11) {

            System.out.println("\n===== BIBLIOTECA FÁCIL =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar leitor");
            System.out.println("3 - Cadastrar funcionário");
            System.out.println("4 - Realizar empréstimo");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Listar livros");
            System.out.println("7 - Listar leitores");
            System.out.println("8 - Listar empréstimos");
            System.out.println("9 - Listar livros disponíveis");
            System.out.println("10 - Listar pessoas");
            System.out.println("11 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção e trata entradas que não sejam números.
            String entrada = scanner.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {

                case 1:
                    // Recebe os dados e cadastra um novo livro.
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();

                    System.out.print("Digite o código do livro: ");
                    String codigo = scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, codigo);
                    biblioteca.cadastrarLivro(livro);
                    break;

                case 2:
                    // Recebe os dados e cadastra um novo leitor.
                    System.out.print("Digite o nome do leitor: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o CPF do leitor: ");
                    String cpf = scanner.nextLine();

                    Leitor leitor = new Leitor(nome, cpf);
                    biblioteca.cadastrarLeitor(leitor);
                    break;

                case 3:
                    // Recebe os dados e cadastra um funcionário.
                    System.out.print("Digite o nome do funcionário: ");
                    String nomeFuncionario = scanner.nextLine();

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfFuncionario = scanner.nextLine();

                    System.out.print("Digite a matrícula: ");
                    String matricula = scanner.nextLine();

                    System.out.print("Digite o cargo: ");
                    String cargo = scanner.nextLine();

                    Funcionario funcionario = new Funcionario(
                            nomeFuncionario, cpfFuncionario, matricula, cargo);

                    biblioteca.cadastrarFuncionario(funcionario);
                    break;

                case 4:
                    // Localiza o leitor e o livro para realizar o empréstimo.
                    System.out.print("Digite o CPF do leitor: ");
                    String cpfEmprestimo = scanner.nextLine();

                    System.out.print("Digite o código do livro: ");
                    String codigoEmprestimo = scanner.nextLine();

                    Leitor leitorEmprestimo =
                            biblioteca.buscarLeitorPorCpf(cpfEmprestimo);

                    Livro livroEmprestimo =
                            biblioteca.buscarLivroPorCodigo(codigoEmprestimo);

                    biblioteca.realizarEmprestimo(leitorEmprestimo, livroEmprestimo);
                    break;

                case 5:
                    // Solicita o código do livro para realizar a devolução.
                    System.out.print("Digite o código do livro: ");
                    String codigoDevolucao = scanner.nextLine();

                    biblioteca.devolverLivro(codigoDevolucao);
                    break;

                case 6:
                    // Lista todos os livros cadastrados.
                    biblioteca.listarLivros();
                    break;

                case 7:
                    // Lista somente os leitores cadastrados.
                    biblioteca.listarLeitores();
                    break;

                case 8:
                    // Lista todos os empréstimos registrados.
                    biblioteca.listarEmprestimos();
                    break;

                case 9:
                    // Lista somente os livros disponíveis.
                    biblioteca.listarLivros(true);
                    break;

                case 10:
                    // Lista leitores e funcionários utilizando o polimorfismo.
                    biblioteca.listarPessoas();
                    break;

                case 11:
                    // Encerra a execução do sistema.
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    // Trata opções inexistentes ou entradas inválidas.
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        // Fecha o Scanner ao encerrar o sistema.
        scanner.close();
    }
}
