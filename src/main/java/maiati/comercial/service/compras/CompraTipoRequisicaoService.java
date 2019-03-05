package maiati.comercial.service.compras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.compras.CompraTipoRequisicao;
import maiati.comercial.repository.compras.CompraTipoRequisicaoRepository;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Service
public class CompraTipoRequisicaoService {

	@Autowired
	private CompraTipoRequisicaoRepository repository;

	/* Listar Todos */
	public List<CompraTipoRequisicao> listarTodos() {
		return repository.findAll();
	}

	/* Listar por nome */
	public List<CompraTipoRequisicao> listarPorNome(String nome) {
		return repository.findFirst10ByNomeContaining(nome);
	}
	/* Buscar por ID */
	public CompraTipoRequisicao buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public CompraTipoRequisicao salvaObj(CompraTipoRequisicao obj) {
		return repository.save(obj);
	}

	/* Excluir */ 
	public void excluir(Integer id) {
		CompraTipoRequisicao obj = new CompraTipoRequisicao();
		obj.setId(id);
		repository.delete(obj);
	}
}
