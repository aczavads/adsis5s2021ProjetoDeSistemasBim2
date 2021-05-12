package br.unicesumar.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaRepositoryTransient {
	private List<Pessoa> dados = new ArrayList<Pessoa>();

	public void incluir(Pessoa nova) {
		dados.add(nova);
	}

	public List<Pessoa> encontrarTodos() {
		return this.dados;
	}

	public List<Pessoa> obterProfessoresExclusivos() {
		return dados.stream()
				.filter(p -> p.getClass() == Física.class)
				.filter(p -> ((Física)p).isProfessor())
				.filter(p -> !((Física)p).isAluno())
				.collect(Collectors.toList());
	}

	public List<Pessoa> obterAlunosExclusivos() {
		return dados.stream()
				.filter(p -> p.getClass() == Física.class)
				.filter(p -> ((Física)p).isAluno())
				.filter(p -> !((Física)p).isProfessor())
				.collect(Collectors.toList());
	}

}
