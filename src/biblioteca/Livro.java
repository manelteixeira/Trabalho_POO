package biblioteca;

//Livro implementa o contrato Identificavel.
public class Livro implements Identificavel{
	
	// Atributos privados: protegem os dados do livro.
	private String titulo;
	private String autor;
	private String codigo;
	private boolean disponivel;
	
	// Construtor principal.
	public Livro(String titulo, String autor, String codigo) {
		this.titulo = titulo;
		this.autor = autor;
		this.codigo = codigo;
		this.disponivel = true; // Todo livro começa disponível.
	}

	// Retorna a identificação do livro.
	@Override
	public String getIdentificacao() {
		return codigo;
	}
	
	// Consulta os dados do livro.
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	// Verifica se o livro está disponível.
	public boolean isDisponivel() {
		return disponivel;
	}
	
	// Altera a disponibilidade do livro.
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}
