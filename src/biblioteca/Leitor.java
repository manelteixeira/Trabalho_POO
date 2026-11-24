package biblioteca;

//Leitor herda os atributos e métodos da classe Pessoa.
public class Leitor extends Pessoa{
	
	// Construtor recebe os dados e repassa para Pessoa.
	public Leitor(String nome, String cpf) {
		super(nome,cpf);
	}
	
	// Implementa o método abstrato definido em Pessoa.
	
	@Override
	public void exibirDados() {
		System.out.println("Nome: "+ getNome());
		System.out.println("CPF: " + getCpf());
	}

}
