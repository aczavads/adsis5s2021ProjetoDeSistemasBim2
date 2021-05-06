package br.unicesumar.pessoa;

public class Física extends Pessoa {
	private String rg;
	private String cpf;
	private String nomeSocial;
	
	public Física(String nome, String rg, String cpf) {
		super(nome);
		this.rg = rg;
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
}
