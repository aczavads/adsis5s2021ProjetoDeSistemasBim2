package br.unicesumar.pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryTransient {
	private List<Pessoa> dados = new ArrayList<Pessoa>();

	public void incluir(Pessoa nova) {
		dados.add(nova);
	}

	public List<Pessoa> encontrarTodos() {
		return this.dados;
	}

}
