package modelo;

import java.util.ArrayList;

public class Professor {
private	String nome;
	ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	public Professor(){
		
	}
	public Professor(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
