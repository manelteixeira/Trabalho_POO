
package biblioteca;

// Classe abstrata que representa uma pessoa no sistema.
public abstract class Pessoa {

	// Atributos privados para proteger os dados da pessoa.
	private String nome;
	private String cpf;

	// Exibe os dados básicos compartilhados pelas subclasses.
	protected void exibirIdentificacaoBasica() {
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
	}

	// Construtor utilizado para inicializar nome e CPF.
	public Pessoa(String nome, String cpf) {

		this.nome = nome;
		this.cpf = cpf;

	}

	// Retorna o nome da pessoa.
	public String getNome() {

		return nome;

	}

	// Altera o nome da pessoa.
	public void setNome(String nome) {

		this.nome = nome;

	}

	// Retorna o CPF da pessoa.
	public String getCpf() {

		return cpf;

	}

	// Altera o CPF da pessoa.
	public void setCpf(String cpf) {

		this.cpf = cpf;

	}

	// Método abstrato que deverá ser implementado pelas classes filhas.
	public abstract void exibirDados();

}