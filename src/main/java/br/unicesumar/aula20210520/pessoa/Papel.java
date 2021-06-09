package br.unicesumar.aula20210520.pessoa;

import java.util.Date;

public abstract class Papel {
	private Date vinculadoEm;
	private Date vinculadoAté;
	
	public Papel(Date vinculadoEm, Date vinculadoAté) {
		super();
		this.vinculadoEm = vinculadoEm;
		this.vinculadoAté = vinculadoAté;
	}
	
	public Date getVinculadoEm() {
		return vinculadoEm;
	}
	
	public Date getVinculadoAté() {
		return vinculadoAté;
	}
	
	public Date getVinculadoAté(Date dataAlternativaSeNull) {
		return vinculadoAté == null ? dataAlternativaSeNull : vinculadoAté;
	}
	
	public void setVinculadoAté(Date vinculadoAté) {
		this.vinculadoAté = vinculadoAté;
	}
	
	public void setVinculadoEm(Date vinculadoEm) {
		this.vinculadoEm = vinculadoEm;
	}
	
	public abstract boolean possívelVincularA(Pessoa pessoaQueAssumiráEstePapel);

}
