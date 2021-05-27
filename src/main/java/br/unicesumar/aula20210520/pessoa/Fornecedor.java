package br.unicesumar.aula20210520.pessoa;

import java.util.Date;

public class Fornecedor extends Papel {

	public Fornecedor(Date vinculadoEm, Date vinculadoAté) {
		super(vinculadoEm, vinculadoAté);
	}

	@Override
	public boolean possívelVincularA(Pessoa pessoaQueAssumiráEstePapel) {
		if (pessoaQueAssumiráEstePapel instanceof Física || pessoaQueAssumiráEstePapel instanceof Jurídica) {
			return true;
		}
		return false;
	}

}
