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
@Table(name="fin_fechamento_caixa_banco")
@NamedQuery(name="FinFechamentoCaixaBanco.findAll", query="SELECT f FROM FinFechamentoCaixaBanco f")
public class FinFechamentoCaixaBanco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ano;

	@Column(name="CHEQUE_NAO_COMPENSADO")
	private BigDecimal chequeNaoCompensado;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_FECHAMENTO")
	private Date dataFechamento;

	private String mes;

	@Column(name="MES_ANO")
	private String mesAno;

	private BigDecimal pagamentos;

	private BigDecimal recebimentos;

	@Column(name="SALDO_ANTERIOR")
	private BigDecimal saldoAnterior;

	@Column(name="SALDO_CONTA")
	private BigDecimal saldoConta;

	@Column(name="SALDO_DISPONIVEL")
	private BigDecimal saldoDisponivel;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;

	public FinFechamentoCaixaBanco() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public BigDecimal getChequeNaoCompensado() {
		return this.chequeNaoCompensado;
	}

	public void setChequeNaoCompensado(BigDecimal chequeNaoCompensado) {
		this.chequeNaoCompensado = chequeNaoCompensado;
	}

	public Date getDataFechamento() {
		return this.dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getMesAno() {
		return this.mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	public BigDecimal getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(BigDecimal pagamentos) {
		this.pagamentos = pagamentos;
	}

	public BigDecimal getRecebimentos() {
		return this.recebimentos;
	}

	public void setRecebimentos(BigDecimal recebimentos) {
		this.recebimentos = recebimentos;
	}

	public BigDecimal getSaldoAnterior() {
		return this.saldoAnterior;
	}

	public void setSaldoAnterior(BigDecimal saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public BigDecimal getSaldoConta() {
		return this.saldoConta;
	}

	public void setSaldoConta(BigDecimal saldoConta) {
		this.saldoConta = saldoConta;
	}

	public BigDecimal getSaldoDisponivel() {
		return this.saldoDisponivel;
	}

	public void setSaldoDisponivel(BigDecimal saldoDisponivel) {
		this.saldoDisponivel = saldoDisponivel;
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
		FinFechamentoCaixaBanco other = (FinFechamentoCaixaBanco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}