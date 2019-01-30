package maiati.comercial.model.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name="fin_parcela_pagar")
@NamedQuery(name="FinParcelaPagar.findAll", query="SELECT f FROM FinParcelaPagar f")
public class FinParcelaPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_EMISSAO")
	private Date dataEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_VENCIMENTO")
	private Date dataVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name="DESCONTO_ATE")
	private Date descontoAte;

	@Column(name="NUMERO_PARCELA")
	private Integer numeroParcela;

	private BigDecimal valor;

	//bi-directional many-to-one association to FinStatusParcela
	@ManyToOne
	@JoinColumn(name="ID_FIN_STATUS_PARCELA")
	private FinStatusParcela finStatusParcela;

	//bi-directional many-to-one association to FinLancamentoPagar
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_FIN_LANCAMENTO_PAGAR")
	private FinLancamentoPagar finLancamentoPagar;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;
	
	@OneToMany(mappedBy="finParcelaPagar", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FinParcelaPagamento> listaFinParcelaPagamento;
	
	public FinParcelaPagar() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public FinStatusParcela getFinStatusParcela() {
		return this.finStatusParcela;
	}

	public void setFinStatusParcela(FinStatusParcela finStatusParcela) {
		this.finStatusParcela = finStatusParcela;
	}

	public FinLancamentoPagar getFinLancamentoPagar() {
		return this.finLancamentoPagar;
	}

	public void setFinLancamentoPagar(FinLancamentoPagar finLancamentoPagar) {
		this.finLancamentoPagar = finLancamentoPagar;
	}

	public ContaCaixa getContaCaixa() {
		return this.contaCaixa;
	}

	public void setContaCaixa(ContaCaixa contaCaixa) {
		this.contaCaixa = contaCaixa;
	}

	public Set<FinParcelaPagamento> getListaFinParcelaPagamento() {
		return listaFinParcelaPagamento;
	}

	public void setListaFinParcelaPagamento(Set<FinParcelaPagamento> listaFinParcelaPagamento) {
		this.listaFinParcelaPagamento = listaFinParcelaPagamento;
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
		FinParcelaPagar other = (FinParcelaPagar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}