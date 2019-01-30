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

import maiati.comercial.model.cadastros.Cliente;


/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="fin_lancamento_receber")
@NamedQuery(name="FinLancamentoReceber.findAll", query="SELECT f FROM FinLancamentoReceber f")
public class FinLancamentoReceber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_LANCAMENTO")
	private Date dataLancamento;

	@Column(name="INTERVALO_ENTRE_PARCELAS")
	private Integer intervaloEntreParcelas;

	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;

	@Temporal(TemporalType.DATE)
	@Column(name="PRIMEIRO_VENCIMENTO")
	private Date primeiroVencimento;

	@Column(name="QUANTIDADE_PARCELA")
	private Integer quantidadeParcela;

	@Column(name="TAXA_COMISSAO")
	private BigDecimal taxaComissao;

	@Column(name="VALOR_A_RECEBER")
	private BigDecimal valorAReceber;

	@Column(name="VALOR_COMISSAO")
	private BigDecimal valorComissao;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to FinDocumentoOrigem
	@ManyToOne
	@JoinColumn(name="ID_FIN_DOCUMENTO_ORIGEM")
	private FinDocumentoOrigem finDocumentoOrigem;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to FinNaturezaFinanceira
	@ManyToOne
	@JoinColumn(name="ID_FIN_NATUREZA_FINANCEIRA")
	private FinNaturezaFinanceira finNaturezaFinanceira;

	@OneToMany(mappedBy="finLancamentoReceber", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FinParcelaReceber> listaFinParcelaReceber;

	public FinLancamentoReceber() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getIntervaloEntreParcelas() {
		return this.intervaloEntreParcelas;
	}

	public void setIntervaloEntreParcelas(Integer intervaloEntreParcelas) {
		this.intervaloEntreParcelas = intervaloEntreParcelas;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getPrimeiroVencimento() {
		return this.primeiroVencimento;
	}

	public void setPrimeiroVencimento(Date primeiroVencimento) {
		this.primeiroVencimento = primeiroVencimento;
	}

	public Integer getQuantidadeParcela() {
		return this.quantidadeParcela;
	}

	public void setQuantidadeParcela(Integer quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public BigDecimal getTaxaComissao() {
		return this.taxaComissao;
	}

	public void setTaxaComissao(BigDecimal taxaComissao) {
		this.taxaComissao = taxaComissao;
	}

	public BigDecimal getValorAReceber() {
		return this.valorAReceber;
	}

	public void setValorAReceber(BigDecimal valorAReceber) {
		this.valorAReceber = valorAReceber;
	}

	public BigDecimal getValorComissao() {
		return this.valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public FinDocumentoOrigem getFinDocumentoOrigem() {
		return this.finDocumentoOrigem;
	}

	public void setFinDocumentoOrigem(FinDocumentoOrigem finDocumentoOrigem) {
		this.finDocumentoOrigem = finDocumentoOrigem;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FinNaturezaFinanceira getFinNaturezaFinanceira() {
		return this.finNaturezaFinanceira;
	}

	public void setFinNaturezaFinanceira(FinNaturezaFinanceira finNaturezaFinanceira) {
		this.finNaturezaFinanceira = finNaturezaFinanceira;
	}

	public Set<FinParcelaReceber> getListaFinParcelaReceber() {
		return listaFinParcelaReceber;
	}

	public void setListaFinParcelaReceber(Set<FinParcelaReceber> listaFinParcelaReceber) {
		this.listaFinParcelaReceber = listaFinParcelaReceber;
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
		FinLancamentoReceber other = (FinLancamentoReceber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}