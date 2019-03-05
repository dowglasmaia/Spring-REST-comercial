package maiati.comercial.repository.cadastros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maiati.comercial.model.cadastros.Pessoa;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	/* Buscar pelo nome com Padrão do SpringJPA - com Padrão de mostra os 10 Primeiros Registros*/
	List<Pessoa> findFirst10ByNomeContaining(String nome);

	
}
