package maiati.comercial.model.financeiro;

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

import maiati.comercial.model.cadastros.ContaCaixa;


/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="fin_configuracao_boleto")
@NamedQuery(name="FinConfiguracaoBoleto.findAll", query="SELECT f FROM FinConfiguracaoBoleto f")
public class FinConfiguracaoBoleto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String aceite;

	@Column(name="CAMINHO_ARQUIVO_LOGOTIPO")
	private String caminhoArquivoLogotipo;

	@Column(name="CAMINHO_ARQUIVO_PDF")
	private String caminhoArquivoPdf;

	@Column(name="CAMINHO_ARQUIVO_REMESSA")
	private String caminhoArquivoRemessa;

	@Column(name="CAMINHO_ARQUIVO_RETORNO")
	private String caminhoArquivoRetorno;

	private String carteira;

	@Column(name="CODIGO_CEDENTE")
	private String codigoCedente;

	@Column(name="CODIGO_CONVENIO")
	private String codigoConvenio;

	private String especie;

	private String instrucao01;

	private String instrucao02;

	@Column(name="LAYOUT_REMESSA")
	private String layoutRemessa;

	@Column(name="LOCAL_PAGAMENTO")
	private String localPagamento;

	private String mensagem;

	@Column(name="TAXA_MULTA")
	private BigDecimal taxaMulta;

	//bi-directional many-to-one association to ContaCaixa
	@ManyToOne
	@JoinColumn(name="ID_CONTA_CAIXA")
	private ContaCaixa contaCaixa;

	public FinConfiguracaoBoleto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAceite() {
		return this.aceite;
	}

	public void setAceite(String aceite) {
		this.aceite = aceite;
	}

	public String getCaminhoArquivoLogotipo() {
		return this.caminhoArquivoLogotipo;
	}

	public void setCaminhoArquivoLogotipo(String caminhoArquivoLogotipo) {
		this.caminhoArquivoLogotipo = caminhoArquivoLogotipo;
	}

	public String getCaminhoArquivoPdf() {
		return this.caminhoArquivoPdf;
	}

	public void setCaminhoArquivoPdf(String caminhoArquivoPdf) {
		this.caminhoArquivoPdf = caminhoArquivoPdf;
	}

	public String getCaminhoArquivoRemessa() {
		return this.caminhoArquivoRemessa;
	}

	public void setCaminhoArquivoRemessa(String caminhoArquivoRemessa) {
		this.caminhoArquivoRemessa = caminhoArquivoRemessa;
	}

	public String getCaminhoArquivoRetorno() {
		return this.caminhoArquivoRetorno;
	}

	public void setCaminhoArquivoRetorno(String caminhoArquivoRetorno) {
		this.caminhoArquivoRetorno = caminhoArquivoRetorno;
	}

	public String getCarteira() {
		return this.carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public String getCodigoCedente() {
		return this.codigoCedente;
	}

	public void setCodigoCedente(String codigoCedente) {
		this.codigoCedente = codigoCedente;
	}

	public String getCodigoConvenio() {
		return this.codigoConvenio;
	}

	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getInstrucao01() {
		return this.instrucao01;
	}

	public void setInstrucao01(String instrucao01) {
		this.instrucao01 = instrucao01;
	}

	public String getInstrucao02() {
		return this.instrucao02;
	}

	public void setInstrucao02(String instrucao02) {
		this.instrucao02 = instrucao02;
	}

	public String getLayoutRemessa() {
		return this.layoutRemessa;
	}

	public void setLayoutRemessa(String layoutRemessa) {
		this.layoutRemessa = layoutRemessa;
	}

	public String getLocalPagamento() {
		return this.localPagamento;
	}

	public void setLocalPagamento(String localPagamento) {
		this.localPagamento = localPagamento;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public BigDecimal getTaxaMulta() {
		return this.taxaMulta;
	}

	public void setTaxaMulta(BigDecimal taxaMulta) {
		this.taxaMulta = taxaMulta;
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
		FinConfiguracaoBoleto other = (FinConfiguracaoBoleto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}