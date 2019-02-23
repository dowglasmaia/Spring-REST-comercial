package maiati.comercial.controller;

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
import maiati.comercial.model.cadastros.TipoColaborador;
import maiati.comercial.service.TipoColaboradorService;

/**
 * @author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * Linkedin: www.linkedin.com/in/dowglasmaia
 * */

@RestController
@RequestMapping("/tipo-colaboradores")
public class TipoColaboradorController {

	@Autowired
	private TipoColaboradorService service;

	@GetMapping
	public List<TipoColaborador> listarTodos() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public TipoColaborador buscarPorId(@PathVariable Integer id) {
		try {
			return service.buscarPorId(id);
		} catch (NoSuchElementException e) {
			throw new RecursoNaoEncontradoException("Registro Não Encontrado!");
		}		
	}

	@PostMapping
	public TipoColaborador salvar(@RequestBody TipoColaborador obj) {
		return service.salvaObj(obj);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

}
