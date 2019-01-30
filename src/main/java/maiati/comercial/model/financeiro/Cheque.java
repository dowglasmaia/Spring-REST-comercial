package maiati.comercial.model.financeiro;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@NamedQuery(name="Cheque.findAll", query="SELECT c FROM Cheque c")
public class Cheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_STATUS")
	private Date dataStatus;

	private Integer numero;

	@Column(name="STATUS_CHEQUE")
	private String statusCheque;

	//bi-directional many-to-one association to TalonarioCheque
	@ManyToOne
	@JoinColumn(name="ID_TALONARIO_CHEQUE")
	private TalonarioCheque talonarioCheque;

	public Cheque() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(Date dataStatus) {
		this.dataStatus = dataStatus;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getStatusCheque() {
		return this.statusCheque;
	}

	public void setStatusCheque(String statusCheque) {
		this.statusCheque = statusCheque;
	}

	public TalonarioCheque getTalonarioCheque() {
		return this.talonarioCheque;
	}

	public void setTalonarioCheque(TalonarioCheque talonarioCheque) {
		this.talonarioCheque = talonarioCheque;
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
		Cheque other = (Cheque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}