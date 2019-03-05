package maiati.comercial.repository.compras;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maiati.comercial.model.compras.CompraTipoRequisicao;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Repository
public interface CompraTipoRequisicaoRepository extends JpaRepository<CompraTipoRequisicao, Integer> {
	
	/* Buscar pelo nome com Padrão do SpringJPA - com Padrão de mostra os 10 Primeiros Registros*/
	List<CompraTipoRequisicao> findFirst10ByNomeContaining(String nome);

}
