package maiati.comercial.model.vendas;

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

import maiati.comercial.model.cadastros.Cliente;
import maiati.comercial.model.cadastros.Transportadora;
import maiati.comercial.model.cadastros.Vendedor;


/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="venda_cabecalho")
@NamedQuery(name="VendaCabecalho.findAll", query="SELECT v FROM VendaCabecalho v")
public class VendaCabecalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_SAIDA")
	private Date dataSaida;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_VENDA")
	private Date dataVenda;

	@Column(name="FORMA_PAGAMENTO")
	private String formaPagamento;

	@Column(name="HORA_SAIDA")
	private String horaSaida;

	@Column(name="LOCAL_COBRANCA")
	private String localCobranca;

	@Column(name="LOCAL_ENTREGA")
	private String localEntrega;

	@Column(name="NUMERO_FATURA")
	private Integer numeroFatura;

	@Lob
	private String observacao;

	private String situacao;

	@Column(name="TAXA_COMISSAO")
	private BigDecimal taxaComissao;

	@Column(name="TAXA_DESCONTO")
	private BigDecimal taxaDesconto;

	@Column(name="TIPO_FRETE")
	private String tipoFrete;

	@Column(name="VALOR_COMISSAO")
	private BigDecimal valorComissao;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="VALOR_FRETE")
	private BigDecimal valorFrete;

	@Column(name="VALOR_SEGURO")
	private BigDecimal valorSeguro;

	@Column(name="VALOR_SUBTOTAL")
	private BigDecimal valorSubtotal;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to TipoNotaFiscal
	@ManyToOne
	@JoinColumn(name="ID_TIPO_NOTA_FISCAL")
	private TipoNotaFiscal tipoNotaFiscal;

	//bi-directional many-to-one association to Transportadora
	@ManyToOne
	@JoinColumn(name="ID_TRANSPORTADORA")
	private Transportadora transportadora;

	//bi-directional many-to-one association to VendaCondicoesPagamento
	@ManyToOne
	@JoinColumn(name="ID_VENDA_CONDICOES_PAGAMENTO")
	private VendaCondicoesPagamento vendaCondicoesPagamento;

	//bi-directional many-to-one association to VendaOrcamentoCabecalho
	@ManyToOne
	@JoinColumn(name="ID_VENDA_ORCAMENTO_CABECALHO")
	private VendaOrcamentoCabecalho vendaOrcamentoCabecalho;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="ID_VENDEDOR")
	private Vendedor vendedor;

	@OneToMany(mappedBy = "vendaCabecalho", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VendaDetalhe> listaVendaDetalhe;
	
	public VendaCabecalho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataVenda() {
		return this.dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getHoraSaida() {
		return this.horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getLocalCobranca() {
		return this.localCobranca;
	}

	public void setLocalCobranca(String localCobranca) {
		this.localCobranca = localCobranca;
	}

	public String getLocalEntrega() {
		return this.localEntrega;
	}

	public void setLocalEntrega(String localEntrega) {
		this.localEntrega = localEntrega;
	}

	public Integer getNumeroFatura() {
		return this.numeroFatura;
	}

	public void setNumeroFatura(Integer numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getTaxaComissao() {
		return this.taxaComissao;
	}

	public void setTaxaComissao(BigDecimal taxaComissao) {
		this.taxaComissao = taxaComissao;
	}

	public BigDecimal getTaxaDesconto() {
		return this.taxaDesconto;
	}

	public void setTaxaDesconto(BigDecimal taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}

	public String getTipoFrete() {
		return this.tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public BigDecimal getValorComissao() {
		return this.valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorFrete() {
		return this.valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public BigDecimal getValorSeguro() {
		return this.valorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public BigDecimal getValorSubtotal() {
		return this.valorSubtotal;
	}

	public void setValorSubtotal(BigDecimal valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoNotaFiscal getTipoNotaFiscal() {
		return this.tipoNotaFiscal;
	}

	public void setTipoNotaFiscal(TipoNotaFiscal tipoNotaFiscal) {
		this.tipoNotaFiscal = tipoNotaFiscal;
	}

	public Transportadora getTransportadora() {
		return this.transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public VendaCondicoesPagamento getVendaCondicoesPagamento() {
		return this.vendaCondicoesPagamento;
	}

	public void setVendaCondicoesPagamento(VendaCondicoesPagamento vendaCondicoesPagamento) {
		this.vendaCondicoesPagamento = vendaCondicoesPagamento;
	}

	public VendaOrcamentoCabecalho getVendaOrcamentoCabecalho() {
		return this.vendaOrcamentoCabecalho;
	}

	public void setVendaOrcamentoCabecalho(VendaOrcamentoCabecalho vendaOrcamentoCabecalho) {
		this.vendaOrcamentoCabecalho = vendaOrcamentoCabecalho;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Set<VendaDetalhe> getListaVendaDetalhe() {
		return listaVendaDetalhe;
	}

	public void setListaVendaDetalhe(Set<VendaDetalhe> listaVendaDetalhe) {
		this.listaVendaDetalhe = listaVendaDetalhe;
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
		VendaCabecalho other = (VendaCabecalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}