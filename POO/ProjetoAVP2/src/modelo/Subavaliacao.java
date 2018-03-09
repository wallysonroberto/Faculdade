package modelo;


public class Subavaliacao {
	String nome;
	Float nota;
	
	public Subavaliacao(String nome){
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}
}
