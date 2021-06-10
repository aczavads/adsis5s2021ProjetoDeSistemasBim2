package br.unicesumar.aula20210520.pessoa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


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
		if (!novo.possívelVincularA(this)) {
			throw new PapelInválidoException();
		}
		long contagemDePapéisConflitantes = papéis.stream()
			.filter(atual -> atual.getClass().equals(novo.getClass()))
			.filter(atual -> (novo.getVinculadoEm().compareTo(atual.getVinculadoEm()) >= 0 &&
					          novo.getVinculadoEm().compareTo(atual.getVinculadoAté(new Date()) ) <= 0) ||
            			     (novo.getVinculadoAté().compareTo(atual.getVinculadoEm()) >= 0 &&
			                  novo.getVinculadoAté().compareTo(atual.getVinculadoAté(new Date()) ) <= 0) || 
            			     (novo.getVinculadoEm().compareTo(atual.getVinculadoEm()) <= 0 &&
			                  novo.getVinculadoAté().compareTo(atual.getVinculadoAté(new Date()) ) >= 0))
			.count();
		if (contagemDePapéisConflitantes > 0) {
			throw new PapelConflitanteException();
		}
		this.papéis.add(novo);
	}
	
	public boolean temPapelParaPeríodo(Class<? extends Papel> classe, Date inícioPeríodo, Date fimPeríodo) {
		boolean temPapel = false; 
		
		//Vigência
		//    I                   F
		//Período
		//       ip       fp
		temPapel = 1 == papéis.stream()
			.filter(p -> p.getClass().equals(classe))
			.filter(p -> p.getVinculadoEm().compareTo(inícioPeríodo) <= 0 &&
			             p.getVinculadoAté(fimPeríodo).compareTo(fimPeríodo) >= 0)
			.count();
		
		return temPapel;
	}
	
	public List<Papel> getPapéisVigentes() {
		Date hoje = new Date();
		return papéis.stream()
				.filter(atual -> atual.getVinculadoEm().compareTo(hoje) <= 0 &&
						         atual.getVinculadoAté(hoje).compareTo(hoje) >= 0)
				.collect(Collectors.toList());
	}
}




