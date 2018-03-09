package modelo;

import java.util.ArrayList;


public class Disciplina {
private	String nome;
private	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
private	Professor prof = new Professor();
private Metodo metodologia = new Metodo();
	
public Disciplina(String nome) {
		this.nome = nome;

	}


public ArrayList<Aluno> getAlunos() {
	return alunos;
}


public void addAluno(Aluno alu) {
	alunos.add(alu);
}
 public void mostraAlunos(){
	 for (Aluno al : alunos) {
		System.out.println(al.getNome());
	}
 }

public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public Metodo getMetodologia() {
	return metodologia;

}


public void setMetodologia(Metodo metodologia) {
	this.metodologia = metodologia;
}


}
