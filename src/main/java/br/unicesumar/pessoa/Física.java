package br.unicesumar.pessoa;

public class Física extends Pessoa {
	private String rg;
	private String cpf;
	private String nomeSocial;
	private Professor professor;
	private Aluno aluno;
	
	public Física(String nome, String rg, String cpf) {
		super(nome);
		this.rg = rg;
		this.cpf = cpf;
		this.nomeSocial = nome;
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

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;	
	}
	public String toString() {
		return "Pessoa [nome="+ this.getNome() + ", rg=" + this.rg + ", cpf=" + this.cpf + ", nomeSocial=" + this.nomeSocial+"]";
	}
	public Professor getProfessor() {
		return professor;
	}
	public Aluno getAluno() {
		return aluno;
	}

	public boolean isProfessor() {
		return this.getProfessor() != null;
	}
	public boolean isAluno() {
		return this.getAluno() != null;
	}
}
