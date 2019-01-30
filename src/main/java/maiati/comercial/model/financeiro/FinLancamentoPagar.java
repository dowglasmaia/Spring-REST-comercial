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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import maiati.comercial.model.cadastros.ContaCaixa;
import maiati.comercial.model.cadastros.Fornecedor;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */
@Entity
@Table(name="fin_lancamento_pagar")
@NamedQuery(name="FinLancamentoPagar.findAll", query="SELECT f FROM FinLancamentoPagar f")
public class FinLancamentoPagar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_LANCAMENTO")
	private Date dataLancamento;

	@Lob
	@Column(name="IMAGEM_DOCUMENTO")
	private String imagemDocumento;

	@Column(name="INTERVALO_ENTRE_PARCELAS")
	private Integer intervaloEntreParcelas;

	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;

	@Temporal(TemporalType.DATE)
	@Column(name="PRIMEIRO_VENCIMENTO")
	private Date primeiroVencimento;

	@Column(name="QUANTIDADE_PARCELA")
	private Integer quantidadeParcela;

	@Column(name="VALOR_A_PAGAR")
	private BigDecimal valorAPagar;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to FinDocumentoOrigem
	@ManyToOne
	@JoinColumn(name="ID_FIN_DOCUMENTO_ORIGEM")
	private FinDocumentoOrigem finDocumentoOrigem;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="ID_FORNECEDOR")
	private Fornecedor fornecedor;

	//bi-directional many-to-one association to FinNaturezaFinanceira
	@ManyToOne
	@JoinColumn(name="ID_FIN_NATUREZA_FINANCEIRA")
	private FinNaturezaFinanceira finNaturezaFinanceira;

	@OneToMany(mappedBy="finLancamentoPagar", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FinParcelaPagar> listaFinParcelaPagar;

	@Transient
	private ContaCaixa contaCaixa;
	
	public FinLancamentoPagar() {
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

	public String getImagemDocumento() {
		return this.imagemDocumento;
	}

	public void setImagemDocumento(String imagemDocumento) {
		this.imagemDocumento = imagemDocumento;
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

	public BigDecimal getValorAPagar() {
		return this.valorAPagar;
	}

	public void setValorAPagar(BigDecimal valorAPagar) {
		this.valorAPagar = valorAPagar;
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

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FinNaturezaFinanceira getFinNaturezaFinanceira() {
		return this.finNaturezaFinanceira;
	}

	public void setFinNaturezaFinanceira(FinNaturezaFinanceira finNaturezaFinanceira) {
		this.finNaturezaFinanceira = finNaturezaFinanceira;
	}

	public Set<FinParcelaPagar> getListaFinParcelaPagar() {
		return listaFinParcelaPagar;
	}

	public void setListaFinParcelaPagar(Set<FinParcelaPagar> listaFinParcelaPagar) {
		this.listaFinParcelaPagar = listaFinParcelaPagar;
	}

	public ContaCaixa getContaCaixa() {
		return contaCaixa;
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
		FinLancamentoPagar other = (FinLancamentoPagar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}