package br.unicesumar.pessoa;

import java.util.Date;

public class Fornecedor {
	private Date vinculadoEm;
	private Date vinculadoAté;
	
	public Date getVinculadoAté() {
		return vinculadoAté;
	}
	
	public Date getVinculadoEm() {
		return vinculadoEm;
	}
	
	public void setVinculadoAté(Date vinculadoAté) {
		this.vinculadoAté = vinculadoAté;
	}
	
	public void setVinculadoEm(Date vinculadoEm) {
		this.vinculadoEm = vinculadoEm;
	}

}
