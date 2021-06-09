package br.unicesumar.aula20210520.pessoa;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class TestesComPapéisDePessoas {


	
	@Test(expected=PapelInválidoException.class)
	public void testarSeJurídicaRecusaPapelDeVeterinário() {
		Pessoa unicesumar = new Jurídica("UniCesumar - Universidade Cesumar"); 
		try {
			unicesumar.adicionarPapel(new Veterinário(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	@Test(expected=PapelInválidoException.class)
	public void testarSeJurídicaRecusaPapelDeProfessor() {
		Pessoa unicesumar = new Jurídica("UniCesumar - Universidade Cesumar"); 
		try {
			unicesumar.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	@Test(expected=PapelInválidoException.class)
	public void testarSeJurídicaRecusaPapelDeALuno() {
		Pessoa unicesumar = new Jurídica("UniCesumar - Universidade Cesumar"); 
		try {
			unicesumar.adicionarPapel(new Aluno(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testarSeJurídicaAceitaPapelDeBancoFornecedor() {
		Pessoa unicesumar = new Jurídica("UniCesumar - Universidade Cesumar"); 
		try {
			unicesumar.adicionarPapel(new Banco(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
			unicesumar.adicionarPapel(new Fornecedor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	
	@Test(expected=PapelInválidoException.class)
	public void testarSeFísicaRecusaPapelDeBanco() {
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Banco(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	@Test
	public void testarSeFísicaAceitaPapelDeAlunoProfessorFornecedorVeterinário() {
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
			ana.adicionarPapel(new Aluno(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
			ana.adicionarPapel(new Fornecedor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
			ana.adicionarPapel(new Veterinário(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));			
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	
	@Test(expected=PapelConflitanteException.class)
	public void testarSeNovoPapelIncorporadoEmAtualComFinalNuloGeraExceção() {
		// E=vinculadoEm  (início)
		// A=vinculadoAté (fim)
		//papel atual                 E                 A
		//papel novo                     E      A
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					null));
			
			ana.adicionarPapel(new Professor(
					criarData("01/01/2019"), 
					criarData("01/02/2020")));
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	
	@Test(expected=PapelConflitanteException.class)
	public void testarSeNovoPapelIncorporadoEmAtualGeraExceção() {
		// E=vinculadoEm  (início)
		// A=vinculadoAté (fim)
		//papel atual                 E                 A
		//papel novo                     E      A
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));
			
			ana.adicionarPapel(new Professor(
					criarData("01/01/2019"), 
					criarData("01/02/2020")));
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	@Test(expected=PapelConflitanteException.class)
	public void testarSeNovoPapelComFimEmAtualGeraExceção() {
		// E=vinculadoEm  (início)
		// A=vinculadoAté (fim)
		//papel atual                 E                 A
		//papel novo               E      A
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));
			
			ana.adicionarPapel(new Professor(
					criarData("01/01/2010"), 
					criarData("01/12/2020")));
		} catch (ParseException e) {
			fail(e.getMessage());
		}		
	}
	@Test(expected=PapelConflitanteException.class)
	public void testarSeNovoPapelComInícioEmAtualGeraExceção() {
		// E=vinculadoEm  (início)
		// A=vinculadoAté (fim)
		//papel atual                 E                 A
		//papel novo                        E               A
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));
			
			ana.adicionarPapel(new Professor(
					criarData("01/02/2018"), 
					criarData("01/02/2021")));
		} catch (ParseException e) {
			fail(e.getMessage());
		}		
		
	}
	@Test(expected=PapelConflitanteException.class)
	public void testarSeNovoPapelQueIncorporeVigênciaDeAtualGeraExceção() {
		// E=vinculadoEm  (início)
		// A=vinculadoAté (fim)
		//papel atual                 E                 A
		//papel novo                E                        A
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));
			
			ana.adicionarPapel(new Professor(
					criarData("01/02/2010"), 
					criarData("01/02/2022")));
		} catch (ParseException e) {
			fail(e.getMessage());
		}		
	}
	
	private Date criarData(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		return sdf.parse(data);
	}

	@Test
	public void testarSeAceitaNovoPapelDeTipoDifernteDeAtual() {
		Pessoa ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));
			
			ana.adicionarPapel(new Aluno(
					criarData("01/01/2018"), 
					criarData("31/12/2020")));
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}
	
}
