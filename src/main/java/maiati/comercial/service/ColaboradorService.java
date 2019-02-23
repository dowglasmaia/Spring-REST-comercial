package maiati.comercial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.cadastros.Colaborador;
import maiati.comercial.repository.ColaboradorRepository;

/**
 * @author Dowglas Maia 
 * Skype: live:dowglasmaia 
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 */

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	/* Listar Todos */
	public List<Colaborador> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Colaborador buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public Colaborador salvaObj(Colaborador obj) {
		return repository.save(obj);
	}

	/* Excluir */
	public void excluir(Integer id) {
		Colaborador obj = new Colaborador();
		obj.setId(id);
		repository.delete(obj);
	}
}
