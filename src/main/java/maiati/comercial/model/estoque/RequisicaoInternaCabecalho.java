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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import maiati.comercial.model.cadastros.Colaborador;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="requisicao_interna_cabecalho")
@NamedQuery(name="RequisicaoInternaCabecalho.findAll", query="SELECT r FROM RequisicaoInternaCabecalho r")
public class RequisicaoInternaCabecalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_REQUISICAO")
	private Date dataRequisicao;

	private String situacao;

	//bi-directional many-to-one association to Colaborador
	@ManyToOne
	@JoinColumn(name="ID_COLABORADOR")
	private Colaborador colaborador;

	//bi-directional many-to-one association to RequisicaoInternaDetalhe
	@OneToMany(mappedBy="requisicaoInternaCabecalho", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<RequisicaoInternaDetalhe> listaRequisicaoInternaDetalhe;

	public RequisicaoInternaCabecalho() {
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

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Set<RequisicaoInternaDetalhe> getListaRequisicaoInternaDetalhe() {
		return listaRequisicaoInternaDetalhe;
	}

	public void setListaRequisicaoInternaDetalhe(Set<RequisicaoInternaDetalhe> listaRequisicaoInternaDetalhe) {
		this.listaRequisicaoInternaDetalhe = listaRequisicaoInternaDetalhe;
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
		RequisicaoInternaCabecalho other = (RequisicaoInternaCabecalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}