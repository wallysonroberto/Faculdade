package modelo;

import java.util.ArrayList;

public class Aluno {
private String nome;
float media=0;


public float getMedia() {
	return media;
}

public void setMedia(float media) {
	this.media = media;
}

public ArrayList<Avaliacao> getAvaliacoes() {
	return avaliacoes;
}

public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
	this.avaliacoes = avaliacoes;
}

ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

public  Aluno(String nome) {
	this.nome=nome;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}



}
