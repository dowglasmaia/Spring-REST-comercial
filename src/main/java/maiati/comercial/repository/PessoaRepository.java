package maiati.comercial.repository;

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

}
