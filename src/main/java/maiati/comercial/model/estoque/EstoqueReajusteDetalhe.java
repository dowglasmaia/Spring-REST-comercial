package maiati.comercial.model.estoque;

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
@Table(name="estoque_reajuste_detalhe")
@NamedQuery(name="EstoqueReajusteDetalhe.findAll", query="SELECT e FROM EstoqueReajusteDetalhe e")
public class EstoqueReajusteDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="VALOR_ORIGINAL")
	private BigDecimal valorOriginal;

	@Column(name="VALOR_REAJUSTE")
	private BigDecimal valorReajuste;

	//bi-directional many-to-one association to EstoqueReajusteCabecalho
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_ESTOQUE_REAJUSTE_CABECALHO")
	private EstoqueReajusteCabecalho estoqueReajusteCabecalho;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="ID_PRODUTO")
	private Produto produto;

	public EstoqueReajusteDetalhe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorOriginal() {
		return this.valorOriginal;
	}

	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public BigDecimal getValorReajuste() {
		return this.valorReajuste;
	}

	public void setValorReajuste(BigDecimal valorReajuste) {
		this.valorReajuste = valorReajuste;
	}

	public EstoqueReajusteCabecalho getEstoqueReajusteCabecalho() {
		return this.estoqueReajusteCabecalho;
	}

	public void setEstoqueReajusteCabecalho(EstoqueReajusteCabecalho estoqueReajusteCabecalho) {
		this.estoqueReajusteCabecalho = estoqueReajusteCabecalho;
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
		EstoqueReajusteDetalhe other = (EstoqueReajusteDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}