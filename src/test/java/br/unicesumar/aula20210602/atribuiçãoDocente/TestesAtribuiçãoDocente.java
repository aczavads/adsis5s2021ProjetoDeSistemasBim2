package br.unicesumar.aula20210602.atribuiçãoDocente;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.unicesumar.aula20210520.pessoa.Física;
import br.unicesumar.aula20210520.pessoa.Professor;

public class TestesAtribuiçãoDocente {

	@Test(expected = AtribuiçãoDocenteInválidaException.class)
	public void testarSeRecusaPessoaQueNãoSejaProfessor() {
		Física ana = new Física("Ana Maria Costa");
		try {
			AtribuiçãoDocente nova = new AtribuiçãoDocente(
					criarData("01/02/2021"),
					criarData("15/07/2021") , 
					ana);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testarSeAceitaPessoaQueSejaProfessorComFinalNulo() {
		Física ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					null));			
			AtribuiçãoDocente nova = new AtribuiçãoDocente(
					criarData("01/02/2021"),
					criarData("15/07/2021") , 
					ana);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testarSeAceitaPessoaQueSejaProfessor() {
		Física ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2021")));			
			AtribuiçãoDocente nova = new AtribuiçãoDocente(
					criarData("01/02/2021"),
					criarData("15/07/2021") , 
					ana);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = AtribuiçãoDocenteInválidaException.class)
	public void testarSeRecusaPessoaQueSejaProfessorEmPeríodoInválido() {
		Física ana = new Física("Ana Maria Costa");
		try {
			ana.adicionarPapel(new Professor(
					criarData("01/01/2018"), 
					criarData("31/12/2018")));			
			ana.adicionarPapel(new Professor(
					criarData("01/01/2020"), 
					criarData("31/12/2020")));			
			AtribuiçãoDocente nova = new AtribuiçãoDocente(
					criarData("01/02/2021"),
					criarData("15/07/2021") , 
					ana);
		} catch (ParseException e) {
			fail(e.getMessage());
		}
	}

	
	private Date criarData(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		return sdf.parse(data);
	}

}
