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
import javax.persistence.Lob;
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
@Table(name="fin_extrato_conta_banco")
@NamedQuery(name="FinExtratoContaBanco.findAll", query="SELECT f FROM FinExtratoContaBanco f")
public class FinExtratoContaBanco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ano;

	private String conciliado;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_BALANCETE")
	private Date dataBalancete;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_MOVIMENTO")
	private Date dataMovimento;

	private String documento;

	private String historico;

	private String mes;

	@Column(name="MES_ANO")
	private String mesAno;

	@Lob
	private String observacao;

	private BigDecimal valor;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;

	public FinExtratoContaBanco() {
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

	public String getConciliado() {
		return this.conciliado;
	}

	public void setConciliado(String conciliado) {
		this.conciliado = conciliado;
	}

	public Date getDataBalancete() {
		return this.dataBalancete;
	}

	public void setDataBalancete(Date dataBalancete) {
		this.dataBalancete = dataBalancete;
	}

	public Date getDataMovimento() {
		return this.dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getHistorico() {
		return this.historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
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

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		FinExtratoContaBanco other = (FinExtratoContaBanco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}