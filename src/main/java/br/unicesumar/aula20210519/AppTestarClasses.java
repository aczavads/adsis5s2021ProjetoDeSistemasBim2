package br.unicesumar.aula20210519;

import br.unicesumar.pessoa.Física;
import br.unicesumar.pessoa.Pessoa;

public class AppTestarClasses {
	
	public static void main(String[] args) {
		Object f = new Física("", "", "");
		
		testarTipo(f, Física.class);
		
	}

	private static void testarTipo(Object objetoQualquer, Class<? extends Pessoa> tipoDesejado) {
		System.out.println(objetoQualquer.getClass() == tipoDesejado);

	}

}
