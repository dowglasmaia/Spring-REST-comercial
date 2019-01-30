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

import maiati.comercial.model.cadastros.ContaCaixa;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="fin_parcela_recebimento")
@NamedQuery(name="FinParcelaRecebimento.findAll", query="SELECT f FROM FinParcelaRecebimento f")
public class FinParcelaRecebimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RECEBIMENTO")
	private Date dataRecebimento;

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

	@Column(name="VALOR_RECEBIDO")
	private BigDecimal valorRecebido;

	//bi-directional many-to-one association to FinParcelaReceber
	@ManyToOne
	@JoinColumn(name="ID_FIN_PARCELA_RECEBER")
	private FinParcelaReceber finParcelaReceber;

	//bi-directional many-to-one association to FinTipoRecebimento
	@ManyToOne
	@JoinColumn(name="ID_FIN_TIPO_RECEBIMENTO")
	private FinTipoRecebimento finTipoRecebimento;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;

	//bi-directional many-to-one association to FinChequeRecebido
	@ManyToOne
	@JoinColumn(name="ID_FIN_CHEQUE_RECEBIDO")
	private FinChequeRecebido finChequeRecebido;

	public FinParcelaRecebimento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataRecebimento() {
		return this.dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
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

	public BigDecimal getValorRecebido() {
		return this.valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public FinParcelaReceber getFinParcelaReceber() {
		return this.finParcelaReceber;
	}

	public void setFinParcelaReceber(FinParcelaReceber finParcelaReceber) {
		this.finParcelaReceber = finParcelaReceber;
	}

	public FinTipoRecebimento getFinTipoRecebimento() {
		return this.finTipoRecebimento;
	}

	public void setFinTipoRecebimento(FinTipoRecebimento finTipoRecebimento) {
		this.finTipoRecebimento = finTipoRecebimento;
	}

	public ContaCaixa getContaCaixa() {
		return this.contaCaixa;
	}

	public void setContaCaixa(ContaCaixa contaCaixa) {
		this.contaCaixa = contaCaixa;
	}

	public FinChequeRecebido getFinChequeRecebido() {
		return this.finChequeRecebido;
	}

	public void setFinChequeRecebido(FinChequeRecebido finChequeRecebido) {
		this.finChequeRecebido = finChequeRecebido;
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
		FinParcelaRecebimento other = (FinParcelaRecebimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}