package maiati.comercial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.cadastros.Setor;
import maiati.comercial.repository.SetorRepository;

/**
 * @author Dowglas Maia Skype: live:dowglasmaia E-mail:dowglasmaia@live.com
 *         Linkedin: www.linkedin.com/in/dowglasmaia
 */

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;

	/* Listar Todos */
	public List<Setor> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Setor buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public Setor salvaObj(Setor obj) {
		return repository.save(obj);
	}

	/* Excluir */
	public void excluir(Integer id) {
		Setor obj = new Setor();
		obj.setId(id);
		repository.delete(obj);
	}
	
}
