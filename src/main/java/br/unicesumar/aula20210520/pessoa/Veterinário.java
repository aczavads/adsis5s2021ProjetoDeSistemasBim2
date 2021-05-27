package br.unicesumar.aula20210520.pessoa;

import java.util.Date;

public class Veterinário extends Papel {

	public Veterinário(Date vinculadoEm, Date vinculadoAté) {
		super(vinculadoEm, vinculadoAté);
	}

	@Override
	public boolean possívelVincularA(Pessoa pessoaQueAssumiráEstePapel) {
		if (pessoaQueAssumiráEstePapel instanceof Física) {
			return true;
		}
		return false;
	}

}
