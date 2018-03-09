package modelo;

import java.util.ArrayList;

public class Avaliacao {
private String nome;
ArrayList<Subavaliacao> listaSubAvl = new ArrayList<Subavaliacao>();

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Avaliacao(String nome){
	this.nome=nome;
}

public ArrayList<Subavaliacao> getListaSubAvl() {
	return listaSubAvl;
}

public void setListaSubAvl(ArrayList<Subavaliacao> listaSubAvl) {
	this.listaSubAvl = listaSubAvl;
}



//public Float sumSub(){
//	Float sum=(float) 0;
//	for (Subavaliacao soma : listaSubAvl) {
//		sum+=soma.nota;
//	}
//	return sum;
//}
}
