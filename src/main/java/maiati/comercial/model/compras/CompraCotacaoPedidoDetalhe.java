package maiati.comercial.model.compras;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name = "compra_cotacao_pedido_detalhe")
@NamedQuery(name = "CompraCotacaoPedidoDetalhe.findAll", query = "SELECT c FROM CompraCotacaoPedidoDetalhe c")
public class CompraCotacaoPedidoDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "QUANTIDADE_PEDIDA")
	private BigDecimal quantidadePedida;

	// bi-directional many-to-one association to CompraCotacaoDetalhe
	@ManyToOne
	@JoinColumn(name = "ID_COMPRA_COTACAO_DETALHE")
	private CompraCotacaoDetalhe compraCotacaoDetalhe;

	// bi-directional many-to-one association to CompraPedido
	@ManyToOne
	@JoinColumn(name = "ID_COMPRA_PEDIDO")
	private CompraPedido compraPedido;

	public CompraCotacaoPedidoDetalhe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getQuantidadePedida() {
		return this.quantidadePedida;
	}

	public void setQuantidadePedida(BigDecimal quantidadePedida) {
		this.quantidadePedida = quantidadePedida;
	}

	public CompraCotacaoDetalhe getCompraCotacaoDetalhe() {
		return this.compraCotacaoDetalhe;
	}

	public void setCompraCotacaoDetalhe(CompraCotacaoDetalhe compraCotacaoDetalhe) {
		this.compraCotacaoDetalhe = compraCotacaoDetalhe;
	}

	public CompraPedido getCompraPedido() {
		return this.compraPedido;
	}

	public void setCompraPedido(CompraPedido compraPedido) {
		this.compraPedido = compraPedido;
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
		CompraCotacaoPedidoDetalhe other = (CompraCotacaoPedidoDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}