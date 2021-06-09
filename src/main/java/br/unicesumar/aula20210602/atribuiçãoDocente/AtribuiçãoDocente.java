package br.unicesumar.aula20210602.atribuiçãoDocente;

import java.util.Date;

import br.unicesumar.aula20210520.pessoa.Física;
import br.unicesumar.aula20210520.pessoa.Professor;

public class AtribuiçãoDocente {
	private Date inícioEm;
	private Date términoEm;
	private Física professor;
	
	public AtribuiçãoDocente(Date inícioEm, Date términoEm, Física professor) {
		this.inícioEm = inícioEm;
		this.términoEm = términoEm;
		setProfessor(professor);
	}
	
	private void setProfessor(Física professor) {
		if (!professor.temPapelParaPeríodo(Professor.class, inícioEm, términoEm)) {
			throw new AtribuiçãoDocenteInválidaException();
		}
		this.professor = professor;
	}
			

}
