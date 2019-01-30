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
@Table(name="venda_orcamento_cabecalho")
@NamedQuery(name="VendaOrcamentoCabecalho.findAll", query="SELECT v FROM VendaOrcamentoCabecalho v")
public class VendaOrcamentoCabecalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_CADASTRO")
	private Date dataCadastro;

	@Lob
	private String observacao;

	@Column(name="TAXA_COMISSAO")
	private BigDecimal taxaComissao;

	@Column(name="TAXA_DESCONTO")
	private BigDecimal taxaDesconto;

	private String tipo;

	@Column(name="TIPO_FRETE")
	private String tipoFrete;

	@Temporal(TemporalType.DATE)
	private Date validade;

	@Column(name="VALOR_COMISSAO")
	private BigDecimal valorComissao;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="VALOR_FRETE")
	private BigDecimal valorFrete;

	@Column(name="VALOR_SUBTOTAL")
	private BigDecimal valorSubtotal;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Transportadora
	@ManyToOne
	@JoinColumn(name="ID_TRANSPORTADORA")
	private Transportadora transportadora;

	//bi-directional many-to-one association to VendaCondicoesPagamento
	@ManyToOne
	@JoinColumn(name="ID_VENDA_CONDICOES_PAGAMENTO")
	private VendaCondicoesPagamento vendaCondicoesPagamento;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="ID_VENDEDOR")
	private Vendedor vendedor;

	@OneToMany(mappedBy = "vendaOrcamentoCabecalho", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VendaOrcamentoDetalhe> listaVendaOrcamentoDetalhe;
	
	public VendaOrcamentoCabecalho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoFrete() {
		return this.tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public Date getValidade() {
		return this.validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
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

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Set<VendaOrcamentoDetalhe> getListaVendaOrcamentoDetalhe() {
		return listaVendaOrcamentoDetalhe;
	}

	public void setListaVendaOrcamentoDetalhe(Set<VendaOrcamentoDetalhe> listaVendaOrcamentoDetalhe) {
		this.listaVendaOrcamentoDetalhe = listaVendaOrcamentoDetalhe;
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
		VendaOrcamentoCabecalho other = (VendaOrcamentoCabecalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}