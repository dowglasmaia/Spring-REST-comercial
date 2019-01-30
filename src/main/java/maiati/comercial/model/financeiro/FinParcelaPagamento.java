package maiati.comercial.model.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import maiati.comercial.model.cadastros.ContaCaixa;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="fin_parcela_pagamento")
@NamedQuery(name="FinParcelaPagamento.findAll", query="SELECT f FROM FinParcelaPagamento f")
public class FinParcelaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PAGAMENTO")
	private Date dataPagamento;

	private String historico;

	@Column(name="TAXA_DESCONTO")
	private BigDecimal taxaDesconto;

	@Column(name="TAXA_JURO")
	private BigDecimal taxaJuro;

	@Column(name="TAXA_MULTA")
	private BigDecimal taxaMulta;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="VALOR_JURO")
	private BigDecimal valorJuro;

	@Column(name="VALOR_MULTA")
	private BigDecimal valorMulta;

	@Column(name="VALOR_PAGO")
	private BigDecimal valorPago;

	//bi-directional many-to-one association to FinParcelaPagar
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name="ID_FIN_PARCELA_PAGAR")
	private FinParcelaPagar finParcelaPagar;

	//bi-directional many-to-one association to FinChequeEmitido
	@ManyToOne
	@JoinColumn(name="ID_FIN_CHEQUE_EMITIDO")
	private FinChequeEmitido finChequeEmitido;

	//bi-directional many-to-one association to FinTipoPagamento
	@ManyToOne
	@JoinColumn(name="ID_FIN_TIPO_PAGAMENTO")
	private FinTipoPagamento finTipoPagamento;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;

	public FinParcelaPagamento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public BigDecimal getTaxaDesconto() {
		return this.taxaDesconto;
	}

	public void setTaxaDesconto(BigDecimal taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}

	public BigDecimal getTaxaJuro() {
		return this.taxaJuro;
	}

	public void setTaxaJuro(BigDecimal taxaJuro) {
		this.taxaJuro = taxaJuro;
	}

	public BigDecimal getTaxaMulta() {
		return this.taxaMulta;
	}

	public void setTaxaMulta(BigDecimal taxaMulta) {
		this.taxaMulta = taxaMulta;
	}

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorJuro() {
		return this.valorJuro;
	}

	public void setValorJuro(BigDecimal valorJuro) {
		this.valorJuro = valorJuro;
	}

	public BigDecimal getValorMulta() {
		return this.valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}

	public BigDecimal getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public FinParcelaPagar getFinParcelaPagar() {
		return this.finParcelaPagar;
	}

	public void setFinParcelaPagar(FinParcelaPagar finParcelaPagar) {
		this.finParcelaPagar = finParcelaPagar;
	}

	public FinChequeEmitido getFinChequeEmitido() {
		return this.finChequeEmitido;
	}

	public void setFinChequeEmitido(FinChequeEmitido finChequeEmitido) {
		this.finChequeEmitido = finChequeEmitido;
	}

	public FinTipoPagamento getFinTipoPagamento() {
		return this.finTipoPagamento;
	}

	public void setFinTipoPagamento(FinTipoPagamento finTipoPagamento) {
		this.finTipoPagamento = finTipoPagamento;
	}

	public ContaCaixa getContaCaixa() {
		return this.contaCaixa;
	}

	public void setContaCaixa(ContaCaixa contaCaixa) {
		this.contaCaixa = contaCaixa;
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
		FinParcelaPagamento other = (FinParcelaPagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}