package br.unicesumar.aula20210520.pessoa;

import java.util.ArrayList;
import java.util.List;


public abstract class Pessoa {
	private String nome;
	private List<Papel> papéis = new ArrayList<>();
	
		
	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void adicionarPapel(Papel novo) {
		if (this instanceof Física) {
			if (novo instanceof Banco) {
				throw new PapelInválidoException();
			}
		}
		if (this instanceof Jurídica) {
			if (novo instanceof Professor || novo instanceof Aluno) {
				throw new PapelInválidoException();
			}
		}
		long contagemDePapéisConflitantes = papéis.stream()
			.filter(atual -> atual.getClass().equals(novo.getClass()))
			.filter(atual -> (novo.getVinculadoEm().compareTo(atual.getVinculadoEm()) >= 0 &&
					          novo.getVinculadoEm().compareTo(atual.getVinculadoAté()) <= 0) ||
            			     (novo.getVinculadoAté().compareTo(atual.getVinculadoEm()) >= 0 &&
			                  novo.getVinculadoAté().compareTo(atual.getVinculadoAté()) <= 0) || 
            			     (novo.getVinculadoEm().compareTo(atual.getVinculadoEm()) <= 0 &&
			                  novo.getVinculadoAté().compareTo(atual.getVinculadoAté()) >= 0))
			.count();
		if (contagemDePapéisConflitantes > 0) {
			throw new PapelConflitanteException();
		}
		this.papéis.add(novo);
	}
	
	public List<Papel> getPapéisVigentes() {
		return null;
	}
}
