package maiati.comercial.model.estoque;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name="requisicao_interna_detalhe")
@NamedQuery(name="RequisicaoInternaDetalhe.findAll", query="SELECT r FROM RequisicaoInternaDetalhe r")
public class RequisicaoInternaDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal quantidade;

	//bi-directional many-to-one association to RequisicaoInternaCabecalho
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_REQ_INTERNA_CABECALHO")
	private RequisicaoInternaCabecalho requisicaoInternaCabecalho;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="ID_PRODUTO")
	private Produto produto;

	public RequisicaoInternaDetalhe() {
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

	public RequisicaoInternaCabecalho getRequisicaoInternaCabecalho() {
		return this.requisicaoInternaCabecalho;
	}

	public void setRequisicaoInternaCabecalho(RequisicaoInternaCabecalho requisicaoInternaCabecalho) {
		this.requisicaoInternaCabecalho = requisicaoInternaCabecalho;
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
		RequisicaoInternaDetalhe other = (RequisicaoInternaDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}