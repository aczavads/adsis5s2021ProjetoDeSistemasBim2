package br.unicesumar.aula20210617.grasp.creator;

import java.math.BigDecimal;
import java.util.Date;

public class AppCreator {
	
	public static void main(String[] args) {
		Produto omo = new Produto("Omo Progress");
		Produto fralda = new Produto("Fralda Pampers Confort Sec XXG");
		
		Pedido p1 = new Pedido(1L, new Date());
		p1.adicionarItem(
				fralda, 
				new BigDecimal(2), 
				new BigDecimal("59.99"), 
				new BigDecimal("2.50"));
		p1.adicionarItem(
				omo, 
				new BigDecimal(1), 
				new BigDecimal("19.99"), 
				new BigDecimal("0.00"));
		
		
	}

}
