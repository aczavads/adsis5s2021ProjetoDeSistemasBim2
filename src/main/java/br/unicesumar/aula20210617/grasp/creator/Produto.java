package br.unicesumar.aula20210617.grasp.creator;

public class Produto extends BaseEntity {
	private String nome;
	
	
	public Produto(String nome) {
		super();
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}

}
