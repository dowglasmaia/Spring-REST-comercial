package maiati.comercial.model.estoque;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name = "estoque_contagem_cabecalho")
@NamedQuery(name = "EstoqueContagemCabecalho.findAll", query = "SELECT e FROM EstoqueContagemCabecalho e")
public class EstoqueContagemCabecalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CONTAGEM")
	private Date dataContagem;

	@Column(name = "ESTOQUE_ATUALIZADO")
	private String estoqueAtualizado;

	// bi-directional many-to-one association to EstoqueContagemDetalhe
	@OneToMany(mappedBy = "estoqueContagemCabecalho", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EstoqueContagemDetalhe> listaEstoqueContagemDetalhe;

	public EstoqueContagemCabecalho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataContagem() {
		return this.dataContagem;
	}

	public void setDataContagem(Date dataContagem) {
		this.dataContagem = dataContagem;
	}

	public String getEstoqueAtualizado() {
		return this.estoqueAtualizado;
	}

	public void setEstoqueAtualizado(String estoqueAtualizado) {
		this.estoqueAtualizado = estoqueAtualizado;
	}

	public Set<EstoqueContagemDetalhe> getListaEstoqueContagemDetalhe() {
		return listaEstoqueContagemDetalhe;
	}

	public void setListaEstoqueContagemDetalhe(Set<EstoqueContagemDetalhe> listaEstoqueContagemDetalhe) {
		this.listaEstoqueContagemDetalhe = listaEstoqueContagemDetalhe;
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
		EstoqueContagemCabecalho other = (EstoqueContagemCabecalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}