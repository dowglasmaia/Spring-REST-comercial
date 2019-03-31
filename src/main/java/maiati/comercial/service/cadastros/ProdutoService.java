package maiati.comercial.service.cadastros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.cadastros.Produto;
import maiati.comercial.repository.cadastros.ProdutoRepository;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	/* Listar Todos */
	public List<Produto> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Produto buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public Produto salvaObj(Produto produto) {
		return repository.save(produto);
	}
	
	/* Listar por Descricao */
	public List<Produto> getDescricao(String descricao) {
		return repository.findByDescricao(descricao);
	}

	/* Excluir */
	public void excluir(Integer id) {
		Produto produto = new Produto();
		produto.setId(id);
		repository.delete(produto);
	}
}
