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
@Table(name="compra_requisicao_detalhe")
@NamedQuery(name="CompraRequisicaoDetalhe.findAll", query="SELECT c FROM CompraRequisicaoDetalhe c")
public class CompraRequisicaoDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ITEM_COTADO")
	private String itemCotado;

	private BigDecimal quantidade;

	@Column(name="QUANTIDADE_COTADA")
	private BigDecimal quantidadeCotada;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_COMPRA_REQUISICAO")
	private CompraRequisicao compraRequisicao;
	
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUTO")
	private Produto produto;

	public CompraRequisicaoDetalhe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCotado() {
		return this.itemCotado;
	}

	public void setItemCotado(String itemCotado) {
		this.itemCotado = itemCotado;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getQuantidadeCotada() {
		return this.quantidadeCotada;
	}

	public void setQuantidadeCotada(BigDecimal quantidadeCotada) {
		this.quantidadeCotada = quantidadeCotada;
	}

	public CompraRequisicao getCompraRequisicao() {
		return this.compraRequisicao;
	}

	public void setCompraRequisicao(CompraRequisicao compraRequisicao) {
		this.compraRequisicao = compraRequisicao;
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
		CompraRequisicaoDetalhe other = (CompraRequisicaoDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}