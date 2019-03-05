package maiati.comercial.model.compras;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import maiati.comercial.model.cadastros.Colaborador;

/**
 * @author Dowglas Maia Skype: live:dowglasmaia E-mail:dowglasmaia@live.com
 *         Linkedin: www.linkedin.com/in/dowglasmaia
 */

@Entity
@Table(name = "compra_requisicao")
@NamedQuery(name = "CompraRequisicao.findAll", query = "SELECT c FROM CompraRequisicao c")
public class CompraRequisicao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_REQUISICAO")
	private Date dataRequisicao;

	@ManyToOne
	@JoinColumn(name = "ID_COMPRA_TIPO_REQUISICAO")
	private CompraTipoRequisicao compraTipoRequisicao;

	@ManyToOne
	@JoinColumn(name = "ID_COLABORADOR")
	private Colaborador colaborador;

	
	
	@OneToMany(mappedBy = "compraRequisicao")
	private Set<CompraRequisicaoDetalhe> listaCompraRequisicaoDetalhes;

	public CompraRequisicao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataRequisicao() {
		return this.dataRequisicao;
	}

	public void setDataRequisicao(Date dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public CompraTipoRequisicao getCompraTipoRequisicao() {
		return this.compraTipoRequisicao;
	}

	public void setCompraTipoRequisicao(CompraTipoRequisicao compraTipoRequisicao) {
		this.compraTipoRequisicao = compraTipoRequisicao;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	

	public Set<CompraRequisicaoDetalhe> getListaCompraRequisicaoDetalhes() {
		return listaCompraRequisicaoDetalhes;
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
		CompraRequisicao other = (CompraRequisicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}