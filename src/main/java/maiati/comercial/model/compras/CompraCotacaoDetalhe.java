package maiati.comercial.model.compras;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import maiati.comercial.model.cadastros.Produto;


/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="compra_cotacao_detalhe")
@NamedQuery(name="CompraCotacaoDetalhe.findAll", query="SELECT c FROM CompraCotacaoDetalhe c")
public class CompraCotacaoDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal quantidade;

	@Column(name="QUANTIDADE_PEDIDA")
	private BigDecimal quantidadePedida;

	@Column(name="TAXA_DESCONTO")
	private BigDecimal taxaDesconto;

	@Column(name="VALOR_DESCONTO")
	private BigDecimal valorDesconto;

	@Column(name="VALOR_SUBTOTAL")
	private BigDecimal valorSubtotal;

	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;

	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;

	//bi-directional many-to-one association to CompraFornecedorCotacao
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_COMPRA_FORNECEDOR_COTACAO")
	private CompraFornecedorCotacao compraFornecedorCotacao;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="ID_PRODUTO")
	private Produto produto;

	public CompraCotacaoDetalhe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getQuantidadePedida() {
		return this.quantidadePedida;
	}

	public void setQuantidadePedida(BigDecimal quantidadePedida) {
		this.quantidadePedida = quantidadePedida;
	}

	public BigDecimal getTaxaDesconto() {
		return this.taxaDesconto;
	}

	public void setTaxaDesconto(BigDecimal taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
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

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public CompraFornecedorCotacao getCompraFornecedorCotacao() {
		return this.compraFornecedorCotacao;
	}

	public void setCompraFornecedorCotacao(CompraFornecedorCotacao compraFornecedorCotacao) {
		this.compraFornecedorCotacao = compraFornecedorCotacao;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		CompraCotacaoDetalhe other = (CompraCotacaoDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}