package br.unicesumar.aula20210617.grasp.creator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido extends BaseEntity {
	private Long número;
	private Date data;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido(Long número, Date data) {
		super();
		this.número = número;
		this.data = data;
	}
	public Date getData() {
		return data;
	}
	public Long getNúmero() {
		return número;
	}
	
	public void adicionarItem(Produto p, BigDecimal q, BigDecimal vu, BigDecimal dp) {
		itens.add(new ItemPedido(this, p, q, vu, dp));
	}
	
	private static class ItemPedido extends BaseEntity {
		private BigDecimal quantidade;
		private BigDecimal valorUnitário;
		private BigDecimal descontoPercentual;
		private Produto produto;
		private Pedido pedido;
				
		public ItemPedido(Pedido ped, Produto p, BigDecimal q, BigDecimal vu, BigDecimal dp) {
			quantidade = q;
			valorUnitário = vu;
			descontoPercentual = dp;
			produto = p;
			pedido = ped;
		}
	}
}
