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

import com.fasterxml.jackson.annotation.JsonIgnore;

import maiati.comercial.model.cadastros.ContaCaixa;


/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="fin_parcela_receber")
@NamedQuery(name="FinParcelaReceber.findAll", query="SELECT f FROM FinParcelaReceber f")
public class FinParcelaReceber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="BOLETO_NOSSO_NUMERO")
	private String boletoNossoNumero;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_EMISSAO")
	private Date dataEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_VENCIMENTO")
	private Date dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name="DESCONTO_ATE")
	private Date descontoAte;

	@Column(name="EMITIU_BOLETO")
	private String emitiuBoleto;

	@Column(name="NUMERO_PARCELA")
	private Integer numeroParcela;

	private BigDecimal valor;

	//bi-directional many-to-one association to FinLancamentoReceber
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_FIN_LANCAMENTO_RECEBER")
	private FinLancamentoReceber finLancamentoReceber;

	//bi-directional many-to-one association to FinStatusParcela
	@ManyToOne
	@JoinColumn(name="ID_FIN_STATUS_PARCELA")
	private FinStatusParcela finStatusParcela;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;

	public FinParcelaReceber() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBoletoNossoNumero() {
		return this.boletoNossoNumero;
	}

	public void setBoletoNossoNumero(String boletoNossoNumero) {
		this.boletoNossoNumero = boletoNossoNumero;
	}

	public Date getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDescontoAte() {
		return this.descontoAte;
	}

	public void setDescontoAte(Date descontoAte) {
		this.descontoAte = descontoAte;
	}

	public String getEmitiuBoleto() {
		return this.emitiuBoleto;
	}

	public void setEmitiuBoleto(String emitiuBoleto) {
		this.emitiuBoleto = emitiuBoleto;
	}

	public Integer getNumeroParcela() {
		return this.numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public FinLancamentoReceber getFinLancamentoReceber() {
		return this.finLancamentoReceber;
	}

	public void setFinLancamentoReceber(FinLancamentoReceber finLancamentoReceber) {
		this.finLancamentoReceber = finLancamentoReceber;
	}

	public FinStatusParcela getFinStatusParcela() {
		return this.finStatusParcela;
	}

	public void setFinStatusParcela(FinStatusParcela finStatusParcela) {
		this.finStatusParcela = finStatusParcela;
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
		FinParcelaReceber other = (FinParcelaReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}