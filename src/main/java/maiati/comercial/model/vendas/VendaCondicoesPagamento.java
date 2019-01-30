package maiati.comercial.model.vendas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="venda_condicoes_pagamento")
@NamedQuery(name="VendaCondicoesPagamento.findAll", query="SELECT v FROM VendaCondicoesPagamento v")
public class VendaCondicoesPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Lob
	private String descricao;

	@Column(name="DIAS_TOLERANCIA")
	private Integer diasTolerancia;

	@Column(name="FATURAMENTO_MAXIMO")
	private BigDecimal faturamentoMaximo;

	@Column(name="FATURAMENTO_MINIMO")
	private BigDecimal faturamentoMinimo;

	@Column(name="INDICE_CORRECAO")
	private BigDecimal indiceCorrecao;

	private String nome;

	@Column(name="PRAZO_MEDIO")
	private Integer prazoMedio;

	@Column(name="VALOR_TOLERANCIA")
	private BigDecimal valorTolerancia;

	@OneToMany(mappedBy = "vendaCondicoesPagamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VendaCondicoesParcela> listaVendaCondicoesParcela;
	
	public VendaCondicoesPagamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDiasTolerancia() {
		return this.diasTolerancia;
	}

	public void setDiasTolerancia(Integer diasTolerancia) {
		this.diasTolerancia = diasTolerancia;
	}

	public BigDecimal getFaturamentoMaximo() {
		return this.faturamentoMaximo;
	}

	public void setFaturamentoMaximo(BigDecimal faturamentoMaximo) {
		this.faturamentoMaximo = faturamentoMaximo;
	}

	public BigDecimal getFaturamentoMinimo() {
		return this.faturamentoMinimo;
	}

	public void setFaturamentoMinimo(BigDecimal faturamentoMinimo) {
		this.faturamentoMinimo = faturamentoMinimo;
	}

	public BigDecimal getIndiceCorrecao() {
		return this.indiceCorrecao;
	}

	public void setIndiceCorrecao(BigDecimal indiceCorrecao) {
		this.indiceCorrecao = indiceCorrecao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPrazoMedio() {
		return this.prazoMedio;
	}

	public void setPrazoMedio(Integer prazoMedio) {
		this.prazoMedio = prazoMedio;
	}

	public BigDecimal getValorTolerancia() {
		return this.valorTolerancia;
	}

	public void setValorTolerancia(BigDecimal valorTolerancia) {
		this.valorTolerancia = valorTolerancia;
	}

	public Set<VendaCondicoesParcela> getListaVendaCondicoesParcela() {
		return listaVendaCondicoesParcela;
	}

	public void setListaVendaCondicoesParcela(Set<VendaCondicoesParcela> listaVendaCondicoesParcela) {
		this.listaVendaCondicoesParcela = listaVendaCondicoesParcela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaCondicoesPagamento other = (VendaCondicoesPagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}