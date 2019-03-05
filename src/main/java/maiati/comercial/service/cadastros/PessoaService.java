package maiati.comercial.service.cadastros;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.cadastros.Pessoa;
import maiati.comercial.repository.cadastros.PessoaRepository;

/**
 * @author Dowglas Maia 
 * Skype: live:dowglasmaia 
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 */

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	/* Listar Todos */
	public List<Pessoa> listarTodos() {
		return repository.findAll();
	}

	/* Listar por nome */
	public List<Pessoa> listarPorNome(String nome) {
		return repository.findFirst10ByNomeContaining(nome);
	}
	
	/* Buscar por ID */
	public Pessoa buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public Pessoa salvaObj(Pessoa obj) {
		return repository.save(obj);
	}

	/* Excluir */
	public void excluir(Integer id) {
		Pessoa obj = new Pessoa();
		obj.setId(id);
		repository.delete(obj);
	}
}
