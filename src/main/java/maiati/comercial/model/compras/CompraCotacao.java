package maiati.comercial.model.compras;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
 * @author Dowglas Maia Skype: live:dowglasmaia E-mail:dowglasmaia@live.com
 *         Linkedin: www.linkedin.com/in/dowglasmaia
 */

@Entity
@Table(name = "compra_cotacao")
@NamedQuery(name = "CompraCotacao.findAll", query = "SELECT c FROM CompraCotacao c")
public class CompraCotacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_COTACAO")
	private Date dataCotacao;

	private String descricao;

	private String situacao;

	@OneToMany(mappedBy = "compraCotacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompraReqCotacaoDetalhe> listaCompraReqCotacaoDetalhes = new HashSet<>();

	@OneToMany(mappedBy = "compraCotacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CompraFornecedorCotacao> listaCompraFornecedorCotacao = new HashSet<>();

	public CompraCotacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCotacao() {
		return this.dataCotacao;
	}

	public void setDataCotacao(Date dataCotacao) {
		this.dataCotacao = dataCotacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Set<CompraReqCotacaoDetalhe> getListaCompraReqCotacaoDetalhes() {
		return listaCompraReqCotacaoDetalhes;
	}

	public void setListaCompraReqCotacaoDetalhes(Set<CompraReqCotacaoDetalhe> listaCompraReqCotacaoDetalhes) {
		this.listaCompraReqCotacaoDetalhes = listaCompraReqCotacaoDetalhes;
	}

	public Set<CompraFornecedorCotacao> getListaCompraFornecedorCotacao() {
		return listaCompraFornecedorCotacao;
	}

	public void setListaCompraFornecedorCotacao(Set<CompraFornecedorCotacao> listaCompraFornecedorCotacao) {
		this.listaCompraFornecedorCotacao = listaCompraFornecedorCotacao;
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
		CompraCotacao other = (CompraCotacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}