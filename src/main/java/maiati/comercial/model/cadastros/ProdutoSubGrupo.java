package maiati.comercial.model.cadastros;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Entity
@Table(name="produto_sub_grupo")
@NamedQuery(name="ProdutoSubGrupo.findAll", query="SELECT p FROM ProdutoSubGrupo p")
public class ProdutoSubGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Lob
	private String descricao;

	private String nome;

	//bi-directional many-to-one association to ProdutoGrupo
	@ManyToOne
	@JoinColumn(name="ID_GRUPO")
	private ProdutoGrupo produtoGrupo;

	public ProdutoSubGrupo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProdutoGrupo getProdutoGrupo() {
		return this.produtoGrupo;
	}

	public void setProdutoGrupo(ProdutoGrupo produtoGrupo) {
		this.produtoGrupo = produtoGrupo;
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
		ProdutoSubGrupo other = (ProdutoSubGrupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}