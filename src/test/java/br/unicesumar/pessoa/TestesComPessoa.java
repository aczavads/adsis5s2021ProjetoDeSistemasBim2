package br.unicesumar.pessoa;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesComPessoa {

	@Test
	public void testarPapelDuplo() {
		Pessoa física = new Física("Marcello Erick Bonfim", "910.822.570-28");
		física.setProfessor(new Professor());
		física.setAluno(new Aluno());
	}

}
