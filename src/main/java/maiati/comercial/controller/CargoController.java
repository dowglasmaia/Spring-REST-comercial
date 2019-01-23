package maiati.comercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maiati.comercial.model.Cargo;
import maiati.comercial.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;

	@GetMapping
	public List<Cargo> listarTodos() {
		return service.listarTodos();
	}

	@GetMapping("/{id}")
	public Cargo buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
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
