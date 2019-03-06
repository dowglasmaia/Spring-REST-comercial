package maiati.comercial.repository.compras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maiati.comercial.model.compras.CompraCotacao;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Repository
public interface CompraContacaoRepository extends JpaRepository<CompraCotacao, Integer> {
	

}
