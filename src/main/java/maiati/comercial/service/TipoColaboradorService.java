package maiati.comercial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.cadastros.TipoColaborador;
import maiati.comercial.repository.TipoColaboradorRepository;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Service
public class TipoColaboradorService {

	@Autowired
	private TipoColaboradorRepository repository;

	/* Listar Todos */
	public List<TipoColaborador> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public TipoColaborador buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public TipoColaborador salvaObj(TipoColaborador TipoColaborador) {
		return repository.save(TipoColaborador);
	}

	/* Excluir */
	public void excluir(Integer id) {
		TipoColaborador TipoColaborador = new TipoColaborador();
		TipoColaborador.setId(id);
		repository.delete(TipoColaborador);
	}
}
