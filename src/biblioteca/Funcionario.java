package biblioteca;

//Funcionario herda as características da classe Pessoa.
public class Funcionario extends Pessoa {

	// Atributos específicos do funcionário.
	private String matricula;
	private String cargo;

	public Funcionario(String nome, String cpf, String matricula, String cargo) {

		// Envia nome e CPF para o construtor da classe Pessoa.
		super(nome, cpf);

		// Inicializa os atributos específicos do funcionário.
		this.matricula = matricula;
		this.cargo = cargo;
	}

	// Retorna a matrícula do funcionário.
	public String getMatricula() {
		return matricula;
	}

	// Altera a matrícula do funcionário.
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	// Retorna o cargo do funcionário.
	public String getCargo() {
		return cargo;
	}

	// Altera o cargo do funcionário.
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	// Sobrescreve o método abstrato definido na classe Pessoa.
	@Override
	public void exibirDados() {
		System.out.println("Nome: " + getNome());
	    System.out.println("CPF: " + getCpf());
	    System.out.println("Matrícula: " + getMatricula());
	    System.out.println("Cargo: " + getCargo());
	}

}
