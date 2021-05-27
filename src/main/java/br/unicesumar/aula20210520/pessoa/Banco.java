package br.unicesumar.aula20210520.pessoa;

import java.util.Date;

public class Banco extends Papel {

	public Banco(Date vinculadoEm, Date vinculadoAté) {
		super(vinculadoEm, vinculadoAté);
	}

	@Override
	public boolean possívelVincularA(Pessoa pessoaQueAssumiráEstePapel) {
		if (pessoaQueAssumiráEstePapel instanceof Jurídica) {
			return true;
		}
		return false;
	}

}
