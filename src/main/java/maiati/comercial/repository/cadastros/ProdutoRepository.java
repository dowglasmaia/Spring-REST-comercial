package maiati.comercial.repository.cadastros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import maiati.comercial.model.cadastros.Produto;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	/* Buscar Por Descrição*/
	@Query("SELECT obj FROM Produto obj WHERE lower(obj.descricao) like concat('%',lower(descricao),'%') ORDER BY obj.descricao")
	public List<Produto> findByDescricao(@Param("estadoId") String descricao);

}
