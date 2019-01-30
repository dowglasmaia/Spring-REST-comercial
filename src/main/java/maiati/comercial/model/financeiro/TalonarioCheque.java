package maiati.comercial.model.financeiro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import maiati.comercial.model.cadastros.ContaCaixa;


/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="talonario_cheque")
@NamedQuery(name="TalonarioCheque.findAll", query="SELECT t FROM TalonarioCheque t")
public class TalonarioCheque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer numero;

	@Column(name="STATUS_TALAO")
	private String statusTalao;

	private String talao;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;

	public TalonarioCheque() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getStatusTalao() {
		return this.statusTalao;
	}

	public void setStatusTalao(String statusTalao) {
		this.statusTalao = statusTalao;
	}

	public String getTalao() {
		return this.talao;
	}

	public void setTalao(String talao) {
		this.talao = talao;
	}

	public ContaCaixa getContaCaixa() {
		return this.contaCaixa;
	}

	public void setContaCaixa(ContaCaixa contaCaixa) {
		this.contaCaixa = contaCaixa;
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
		TalonarioCheque other = (TalonarioCheque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}