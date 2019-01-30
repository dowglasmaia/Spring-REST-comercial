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
@Table(name="estoque_contagem_detalhe")
@NamedQuery(name="EstoqueContagemDetalhe.findAll", query="SELECT e FROM EstoqueContagemDetalhe e")
public class EstoqueContagemDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal acuracidade;

	private BigDecimal divergencia;

	@Column(name="QUANTIDADE_CONTADA")
	private BigDecimal quantidadeContada;

	@Column(name="QUANTIDADE_SISTEMA")
	private BigDecimal quantidadeSistema;

	//bi-directional many-to-one association to EstoqueContagemCabecalho
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_ESTOQUE_CONTAGEM_CABECALHO")
	private EstoqueContagemCabecalho estoqueContagemCabecalho;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="ID_PRODUTO")
	private Produto produto;

	public EstoqueContagemDetalhe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAcuracidade() {
		return this.acuracidade;
	}

	public void setAcuracidade(BigDecimal acuracidade) {
		this.acuracidade = acuracidade;
	}

	public BigDecimal getDivergencia() {
		return this.divergencia;
	}

	public void setDivergencia(BigDecimal divergencia) {
		this.divergencia = divergencia;
	}

	public BigDecimal getQuantidadeContada() {
		return this.quantidadeContada;
	}

	public void setQuantidadeContada(BigDecimal quantidadeContada) {
		this.quantidadeContada = quantidadeContada;
	}

	public BigDecimal getQuantidadeSistema() {
		return this.quantidadeSistema;
	}

	public void setQuantidadeSistema(BigDecimal quantidadeSistema) {
		this.quantidadeSistema = quantidadeSistema;
	}

	public EstoqueContagemCabecalho getEstoqueContagemCabecalho() {
		return this.estoqueContagemCabecalho;
	}

	public void setEstoqueContagemCabecalho(EstoqueContagemCabecalho estoqueContagemCabecalho) {
		this.estoqueContagemCabecalho = estoqueContagemCabecalho;
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
		EstoqueContagemDetalhe other = (EstoqueContagemDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}