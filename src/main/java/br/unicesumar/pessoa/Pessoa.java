package br.unicesumar.pessoa;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
	private String nome;
	private List<Fornecedor> papéisDeFornecedor = new ArrayList<>();
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public boolean isFornecedor() {
		//implementar aqui.
		return false;
	}
	
	public void adicionarPapelFornecedor(Fornecedor f)  {
		//implementar aqui.		
	}
	
	public Fornecedor getPapelFornecedorVigente() {
		//implementar aqui.
		return null;
	}
	
	public List<Fornecedor> getPapéisDeFornecedor() {
		return papéisDeFornecedor;
	}

}
