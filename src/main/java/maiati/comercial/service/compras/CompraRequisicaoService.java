package maiati.comercial.service.compras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.compras.CompraRequisicao;
import maiati.comercial.repository.compras.CompraRequisicaoRepository;

/**
 * @author Dowglas Maia Skype: live:dowglasmaia E-mail:dowglasmaia@live.com
 *         Linkedin: www.linkedin.com/in/dowglasmaia
 */

@Service
public class CompraRequisicaoService {

	@Autowired
	private CompraRequisicaoRepository repository;

	/* Listar Todos */
	public List<CompraRequisicao> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public CompraRequisicao buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public CompraRequisicao salvaObj(CompraRequisicao obj) {
		return repository.save(obj);
	}

	/* Excluir */
	public void excluir(Integer id) {
		CompraRequisicao obj = new CompraRequisicao();
		obj.setId(id);
		repository.delete(obj);
	}
}
