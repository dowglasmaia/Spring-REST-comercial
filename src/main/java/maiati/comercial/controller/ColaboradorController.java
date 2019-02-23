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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import maiati.comercial.exception.RecursoNaoEncontradoException;
import maiati.comercial.model.cadastros.Colaborador;
import maiati.comercial.service.ColaboradorService;

/**
 * @author Dowglas Maia
 */

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@GetMapping
	public List<Colaborador> listarTodos() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public Colaborador buscarPorId(@PathVariable Integer id) {
		try {
			return service.buscarPorId(id);
		} catch (NoSuchElementException e) {
			throw new RecursoNaoEncontradoException("Registro Não Encontrado!");
		}
	}
 
	@PostMapping
	public Colaborador salvar(@RequestBody Colaborador obj) {
		return service.salvaObj(obj);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

	/* Enviando Foto */
	@PostMapping("/upload/{id}")
	public void uploadFoto(@RequestParam ("foto")MultipartFile file, @PathVariable Integer id) {
		try {
			service.uploadFoto(file, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
