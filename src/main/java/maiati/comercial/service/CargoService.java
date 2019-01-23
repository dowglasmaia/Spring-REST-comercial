package maiati.comercial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.Cargo;
import maiati.comercial.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	/* Listar Todos */
	public List<Cargo> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Cargo buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public Cargo salvaObj(Cargo cargo) {
		return repository.save(cargo);
	}

	/* Excluir */
	public void excluir(Integer id) {
		Cargo cargo = new Cargo();
		cargo.setId(id);
		repository.delete(cargo);
	}
}
