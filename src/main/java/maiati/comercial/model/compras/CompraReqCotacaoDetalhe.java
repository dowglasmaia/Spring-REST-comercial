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

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="compra_req_cotacao_detalhe")
@NamedQuery(name="CompraReqCotacaoDetalhe.findAll", query="SELECT c FROM CompraReqCotacaoDetalhe c")
public class CompraReqCotacaoDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="QUANTIDADE_COTADA")
	private BigDecimal quantidadeCotada;

	//bi-directional many-to-one association to CompraRequisicaoDetalhe
	@ManyToOne
	@JoinColumn(name="ID_COMPRA_REQUISICAO_DETALHE")
	private CompraRequisicaoDetalhe compraRequisicaoDetalhe;

	//bi-directional many-to-one association to CompraCotacao
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_COMPRA_COTACAO")
	private CompraCotacao compraCotacao;

	public CompraReqCotacaoDetalhe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getQuantidadeCotada() {
		return this.quantidadeCotada;
	}

	public void setQuantidadeCotada(BigDecimal quantidadeCotada) {
		this.quantidadeCotada = quantidadeCotada;
	}

	public CompraRequisicaoDetalhe getCompraRequisicaoDetalhe() {
		return this.compraRequisicaoDetalhe;
	}

	public void setCompraRequisicaoDetalhe(CompraRequisicaoDetalhe compraRequisicaoDetalhe) {
		this.compraRequisicaoDetalhe = compraRequisicaoDetalhe;
	}

	public CompraCotacao getCompraCotacao() {
		return this.compraCotacao;
	}

	public void setCompraCotacao(CompraCotacao compraCotacao) {
		this.compraCotacao = compraCotacao;
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
		CompraReqCotacaoDetalhe other = (CompraReqCotacaoDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}