package maiati.comercial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maiati.comercial.model.cadastros.Cargo;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	/* Buscar pelo nome com Padrão do SpringJPA*/
	List<Cargo> findByNome(String nome);

}
