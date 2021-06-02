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
		//validar aqui!
		long contagemPapéisDeProfessor = professor.getPapéisVigentes()
				.stream()
				.filter(p -> p instanceof Professor)
				.count();
		if (contagemPapéisDeProfessor == 0) {
			System.out.println("Opa, não encontrei papel de professor, vou lançar a exceção!");
			throw new AtribuiçãoDocenteInválidaException();
		}
		this.professor = professor;
	}
			

}
