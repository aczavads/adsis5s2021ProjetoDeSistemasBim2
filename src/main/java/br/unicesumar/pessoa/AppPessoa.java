package br.unicesumar.pessoa;

public class AppPessoa {
	
	public static void main(String[] args) {
		PessoaRepositoryTransient repo = new PessoaRepositoryTransient();
		
		Física marcello = new Física("Marcello Erick Bonfim","1.123.544-4 SSP-PR", "910.822.570-28");
		marcello.setProfessor(new Professor());
		
		//criar outra pessoa que seja só aluno
		Física josias = new Física("Josias de Alencar", "5.884.554-6 SSP-SC","329.482.840-31");
		josias.setAluno(new Aluno());
		
		
		//criar outra pessoa que seja professor e aluno
		Física nelson = new Física("Nelson Tenório", "1.123.654-1 SSP-MS", "434.167.210-04");
		nelson.setAluno(new Aluno());
		nelson.setProfessor(new Professor());
		
		repo.incluir(marcello);
		repo.incluir(josias);
		repo.incluir(nelson);
		
		listarAlunosExclusivos(repo);
		
		listarProfessoresExclusivos(repo);
		
		//listarPessoasComPapéis(repo);
	}

	private static void listarPessoasComPapéis(PessoaRepositoryTransient repo) {
		for (Pessoa p : repo.encontrarTodos()) {
			//Exibir os dados da pessoa e em seguida os seu(s) papel(éis)
			System.out.println(p);
			if (p instanceof Física) {
				Física auxiliar = (Física) p;
				if (auxiliar.isProfessor())
					System.out.println(">> É professor");
				else 
					System.out.println(">> Não é professor");
				
				if (auxiliar.isAluno())
					System.out.println(">> É aluno");
				else 
					System.out.println(">> Não é aluno");
			}
		}
	}

	private static void listarProfessoresExclusivos(PessoaRepositoryTransient repo) {
		System.out.println("=== Só professores ===");
		for (Pessoa p : repo.obterProfessoresExclusivos() ) {
			System.out.println(p);
		}
		
	}

	private static void listarAlunosExclusivos(PessoaRepositoryTransient repo) {
		System.out.println("=== Só alunos ===");
		for (Pessoa p : repo.obterAlunosExclusivos() ) {
			System.out.println(p);
		}		
	}
}






