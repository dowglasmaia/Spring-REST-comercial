package maiati.comercial.service.cadastros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.cadastros.Setor;
import maiati.comercial.repository.cadastros.SetorRepository;

/**
 * @author Dowglas Maia 
 * Skype: live:dowglasmaia 
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
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
	

	/* Listar por nome */
	public List<Setor> listarPorNome(String nome) {
		return repository.findFirst10ByNomeContaining(nome);
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
