package maiati.comercial.model.estoque;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="estoque_reajuste_cabecalho")
@NamedQuery(name="EstoqueReajusteCabecalho.findAll", query="SELECT e FROM EstoqueReajusteCabecalho e")
public class EstoqueReajusteCabecalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_REAJUSTE")
	private Date dataReajuste;

	private BigDecimal porcentagem;

	@Column(name="TIPO_REAJUSTE")
	private String tipoReajuste;

	//bi-directional many-to-one association to Colaborador
	@ManyToOne
	@JoinColumn(name="ID_COLABORADOR")
	private Colaborador colaborador;

	//bi-directional many-to-one association to EstoqueReajusteDetalhe
	@OneToMany(mappedBy="estoqueReajusteCabecalho", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<EstoqueReajusteDetalhe> listaEstoqueReajusteDetalhe;

	public EstoqueReajusteCabecalho() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataReajuste() {
		return this.dataReajuste;
	}

	public void setDataReajuste(Date dataReajuste) {
		this.dataReajuste = dataReajuste;
	}

	public BigDecimal getPorcentagem() {
		return this.porcentagem;
	}

	public void setPorcentagem(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}

	public String getTipoReajuste() {
		return this.tipoReajuste;
	}

	public void setTipoReajuste(String tipoReajuste) {
		this.tipoReajuste = tipoReajuste;
	}

	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Set<EstoqueReajusteDetalhe> getListaEstoqueReajusteDetalhe() {
		return listaEstoqueReajusteDetalhe;
	}

	public void setListaEstoqueReajusteDetalhe(Set<EstoqueReajusteDetalhe> listaEstoqueReajusteDetalhe) {
		this.listaEstoqueReajusteDetalhe = listaEstoqueReajusteDetalhe;
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
		EstoqueReajusteCabecalho other = (EstoqueReajusteCabecalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}