package br.unicesumar.pessoa;

public class AppPessoa {
	
	public static void main(String[] args) {
		PessoaRepositoryTransient repo = new PessoaRepositoryTransient();
		
		Pessoa marcello = new Física("Marcello Erick Bonfim","1.123.544-4 SSP-PR", "910.822.570-28");
		marcello.setProfessor(new Professor());
		
		//criar outra pessoa que seja só aluno
		Pessoa josias = null; //...
		
		
		//criar outra pessoa que seja professor e aluno
		Pessoa nelson = null; //...
		
		repo.incluir(marcello);
		repo.incluir(josias);
		repo.incluir(nelson);
		
		for (Pessoa p : repo.encontrarTodos()) {
			//Exibir os dados da pessoa e em seguida os seu(s) papel(éis)
		}
	}
}
