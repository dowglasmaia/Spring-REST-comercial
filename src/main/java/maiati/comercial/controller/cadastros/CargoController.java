package maiati.comercial.controller.cadastros;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maiati.comercial.exception.RecursoNaoEncontradoException;
import maiati.comercial.model.cadastros.Cargo;
import maiati.comercial.service.cadastros.CargoService;

/**
 * @author Dowglas Maia Skype: 
 * live:dowglasmaia 
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 */

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;

	@GetMapping
	public List<Cargo> listarTodos() {
		return service.listarTodos();
	}
	
	/* Listar por nome */
	@GetMapping("/lista/{nome}")
	public List<Cargo> findByName(@PathVariable String nome) {
		return service.listarPorNome(nome);
	}

	@GetMapping("/{id}")
	public Cargo buscarPorId(@PathVariable Integer id) {
		try {
			return service.buscarPorId(id);
		} catch (NoSuchElementException e) {
			throw new RecursoNaoEncontradoException("Registro Não Encontrado!");
		}
	}

	@PostMapping
	public Cargo salvar(@RequestBody Cargo cargo) {
		return service.salvaObj(cargo);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

}
