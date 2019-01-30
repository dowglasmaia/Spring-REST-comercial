package maiati.comercial.model.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

import maiati.comercial.model.cadastros.Pessoa;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */
@Entity
@Table(name="fin_cheque_recebido")
@NamedQuery(name="FinChequeRecebido.findAll", query="SELECT f FROM FinChequeRecebido f")
public class FinChequeRecebido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="BOM_PARA")
	private Date bomPara;

	@Column(name="CODIGO_AGENCIA")
	private String codigoAgencia;

	@Column(name="CODIGO_BANCO")
	private String codigoBanco;

	private String conta;

	@Column(name="CPF_CNPJ")
	private String cpfCnpj;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_COMPENSACAO")
	private Date dataCompensacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_EMISSAO")
	private Date dataEmissao;

	private String nome;

	private Integer numero;

	private BigDecimal valor;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="ID_PESSOA")
	private Pessoa pessoa;


	public FinChequeRecebido() {
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

	public String getCodigoAgencia() {
		return this.codigoAgencia;
	}

	public void setCodigoAgencia(String codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public String getCodigoBanco() {
		return this.codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getConta() {
		return this.conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getCpfCnpj() {
		return this.cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		FinChequeRecebido other = (FinChequeRecebido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}