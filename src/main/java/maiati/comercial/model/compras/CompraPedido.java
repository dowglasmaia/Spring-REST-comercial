package maiati.comercial.model.compras;

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

import maiati.comercial.model.cadastros.Fornecedor;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="compra_pedido")
@NamedQuery(name="CompraPedido.findAll", query="SELECT c FROM CompraPedido c")
public class CompraPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String contato;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PEDIDO")
	private Date dataPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PREVISAO_PAGAMENTO")
	private Date dataPrevisaoPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PREVISTA_ENTREGA")
	private Date dataPrevistaEntrega;

	@Column(name="DIAS_INTERVALO")
	private Integer diasIntervalo;

	@Column(name="DIAS_PRIMEIRO_VENCIMENTO")
	private Integer diasPrimeiroVencimento;

	@Column(name="FORMA_PAGAMENTO")
	private String formaPagamento;

	@Column(name="LOCAL_COBRANCA")
	private String localCobranca;

	@Column(name="LOCAL_ENTREGA")
	private String localEntrega;

	@Column(name="QUANTIDADE_PARCELAS")
	private Integer quantidadeParcelas;

	@Column(name="TAXA_DESCONTO")
	private BigDecimal taxaDesconto;

	@Column(name="TIPO_FRETE")
	private String tipoFrete;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="VALOR_SUBTOTAL")
	private BigDecimal valorSubtotal;

	@Column(name="VALOR_TOTAL_PEDIDO")
	private BigDecimal valorTotalPedido;

	//bi-directional many-to-one association to CompraTipoPedido
	@ManyToOne
	@JoinColumn(name="ID_COMPRA_TIPO_PEDIDO")
	private CompraTipoPedido compraTipoPedido;

	//bi-directional many-to-one association to Fornecedor
	@ManyToOne
	@JoinColumn(name="ID_FORNECEDOR")
	private Fornecedor fornecedor;

	public CompraPedido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataPrevisaoPagamento() {
		return this.dataPrevisaoPagamento;
	}

	public void setDataPrevisaoPagamento(Date dataPrevisaoPagamento) {
		this.dataPrevisaoPagamento = dataPrevisaoPagamento;
	}

	public Date getDataPrevistaEntrega() {
		return this.dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public Integer getDiasIntervalo() {
		return this.diasIntervalo;
	}

	public void setDiasIntervalo(Integer diasIntervalo) {
		this.diasIntervalo = diasIntervalo;
	}

	public Integer getDiasPrimeiroVencimento() {
		return this.diasPrimeiroVencimento;
	}

	public void setDiasPrimeiroVencimento(Integer diasPrimeiroVencimento) {
		this.diasPrimeiroVencimento = diasPrimeiroVencimento;
	}

	public String getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
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

	public Integer getQuantidadeParcelas() {
		return this.quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
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

	public BigDecimal getValorDesconto() {
		return this.valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorSubtotal() {
		return this.valorSubtotal;
	}

	public void setValorSubtotal(BigDecimal valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public BigDecimal getValorTotalPedido() {
		return this.valorTotalPedido;
	}

	public void setValorTotalPedido(BigDecimal valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public CompraTipoPedido getCompraTipoPedido() {
		return this.compraTipoPedido;
	}

	public void setCompraTipoPedido(CompraTipoPedido compraTipoPedido) {
		this.compraTipoPedido = compraTipoPedido;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
		CompraPedido other = (CompraPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}