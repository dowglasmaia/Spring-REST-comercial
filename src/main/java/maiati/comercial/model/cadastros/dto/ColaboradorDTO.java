package maiati.comercial.model.cadastros.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import maiati.comercial.model.cadastros.Colaborador;

public class ColaboradorDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String ctpsNumero;

	private String ctpsSerie;

	private String ctpsUf;

	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	private Date dataDemissao;

	@Temporal(TemporalType.DATE)
	private Date ctpsDataExpedicao;

	private String foto34;

	private String matricula;

	private String observacao;

	private String pagamentoAgencia;

	private String pagamentoAgenciaDigito;

	private String pagamentoBanco;

	private String pagamentoConta;

	private String pagamentoContaDigito;

	private String pagamentoForma;

	private String setor;

	private String cargo;

	private String tipoColaborador;

	private String pessoa;

	public ColaboradorDTO() {}

	public ColaboradorDTO(Colaborador obj) {
		this.id = obj.getId();
		this.ctpsNumero = obj.getCtpsNumero();
		this.ctpsSerie = obj.getCtpsSerie();
		this.ctpsUf = obj.getCtpsUf();
		this.dataAdmissao = obj.getDataAdmissao();
		this.dataCadastro = obj.getDataCadastro();
		this.dataDemissao = obj.getDataDemissao();
		this.ctpsDataExpedicao = obj.getCtpsDataExpedicao();
		this.foto34 = obj.getFoto34();
		this.matricula = obj.getMatricula();
		this.observacao = obj.getObservacao();
		this.pagamentoAgencia = obj.getPagamentoAgencia();
		this.pagamentoAgenciaDigito = obj.getPagamentoAgenciaDigito();
		this.pagamentoBanco = obj.getPagamentoBanco();
		this.pagamentoConta = obj.getPagamentoConta();
		this.pagamentoContaDigito = obj.getPagamentoContaDigito();
		this.pagamentoForma = obj.getPagamentoForma();
		this.setor = obj.getSetor().getNome();
		this.cargo = obj.getCargo().getNome();
		this.tipoColaborador = obj.getTipoColaborador().getNome();
		this.pessoa = obj.getPessoa().getNome();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCtpsNumero() {
		return ctpsNumero;
	}

	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}

	public String getCtpsSerie() {
		return ctpsSerie;
	}

	public void setCtpsSerie(String ctpsSerie) {
		this.ctpsSerie = ctpsSerie;
	}

	public String getCtpsUf() {
		return ctpsUf;
	}

	public void setCtpsUf(String ctpsUf) {
		this.ctpsUf = ctpsUf;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Date getCtpsDataExpedicao() {
		return ctpsDataExpedicao;
	}

	public void setCtpsDataExpedicao(Date ctpsDataExpedicao) {
		this.ctpsDataExpedicao = ctpsDataExpedicao;
	}

	public String getFoto34() {
		return foto34;
	}

	public void setFoto34(String foto34) {
		this.foto34 = foto34;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPagamentoAgencia() {
		return pagamentoAgencia;
	}

	public void setPagamentoAgencia(String pagamentoAgencia) {
		this.pagamentoAgencia = pagamentoAgencia;
	}

	public String getPagamentoAgenciaDigito() {
		return pagamentoAgenciaDigito;
	}

	public void setPagamentoAgenciaDigito(String pagamentoAgenciaDigito) {
		this.pagamentoAgenciaDigito = pagamentoAgenciaDigito;
	}

	public String getPagamentoBanco() {
		return pagamentoBanco;
	}

	public void setPagamentoBanco(String pagamentoBanco) {
		this.pagamentoBanco = pagamentoBanco;
	}

	public String getPagamentoConta() {
		return pagamentoConta;
	}

	public void setPagamentoConta(String pagamentoConta) {
		this.pagamentoConta = pagamentoConta;
	}

	public String getPagamentoContaDigito() {
		return pagamentoContaDigito;
	}

	public void setPagamentoContaDigito(String pagamentoContaDigito) {
		this.pagamentoContaDigito = pagamentoContaDigito;
	}

	public String getPagamentoForma() {
		return pagamentoForma;
	}

	public void setPagamentoForma(String pagamentoForma) {
		this.pagamentoForma = pagamentoForma;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTipoColaborador() {
		return tipoColaborador;
	}

	public void setTipoColaborador(String tipoColaborador) {
		this.tipoColaborador = tipoColaborador;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

}
