package maiati.comercial.model.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="fin_cheque_emitido")
@NamedQuery(name="FinChequeEmitido.findAll", query="SELECT f FROM FinChequeEmitido f")
public class FinChequeEmitido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="BOM_PARA")
	private Date bomPara;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_COMPENSACAO")
	private Date dataCompensacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_EMISSAO")
	private Date dataEmissao;

	@Column(name="NOMINAL_A")
	private String nominalA;

	private BigDecimal valor;

	//bi-directional many-to-one association to Cheque
	@ManyToOne
	@JoinColumn(name="ID_CHEQUE")
	private Cheque cheque;
	
	@Transient
	private List<FinParcelaPagar> listaFinParcelaPagar;

	public FinChequeEmitido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBomPara() {
		return this.bomPara;
	}

	public void setBomPara(Date bomPara) {
		this.bomPara = bomPara;
	}

	public Date getDataCompensacao() {
		return this.dataCompensacao;
	}

	public void setDataCompensacao(Date dataCompensacao) {
		this.dataCompensacao = dataCompensacao;
	}

	public Date getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getNominalA() {
		return this.nominalA;
	}

	public void setNominalA(String nominalA) {
		this.nominalA = nominalA;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cheque getCheque() {
		return this.cheque;
	}

	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}

	public List<FinParcelaPagar> getListaFinParcelaPagar() {
		return listaFinParcelaPagar;
	}

	public void setListaFinParcelaPagar(List<FinParcelaPagar> listaFinParcelaPagar) {
		this.listaFinParcelaPagar = listaFinParcelaPagar;
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
		FinChequeEmitido other = (FinChequeEmitido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}