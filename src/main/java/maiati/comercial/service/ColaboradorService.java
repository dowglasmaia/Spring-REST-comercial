package maiati.comercial.service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import maiati.comercial.model.cadastros.Colaborador;
import maiati.comercial.repository.ColaboradorRepository;

/**
 * @author Dowglas Maia *
 */

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	@Autowired
	private ServletContext context; /* necessario para metodo de enviar foto */

	/* Listar Todos */
	public List<Colaborador> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public Colaborador buscarPorId(Integer id) {
		return repository.findById(id).get();
	}
	

	/* Salvar */
	public Colaborador salvaObj(Colaborador obj) {
		return repository.save(obj);
	}

	/* Excluir */
	public void excluir(Integer id) {
		Colaborador obj = new Colaborador();
		obj.setId(id);
		repository.delete(obj);
	}

	/* Enviando Foto do Colaborador para o servidor */
	@SuppressWarnings("unused")
	public void uploadFoto(MultipartFile file, Integer id) throws Exception {
		String caminhoArquivo = context.getRealPath("/"); // setando para pasta Raiz do Servidor
		
		System.out.println(caminhoArquivo);
		
		File pasta = new File(caminhoArquivo + "\\images\\colaborador\\");
		/* Verifico se a Pasta Exite - se não criamos a mesma*/
		if(!pasta.exists()) {
			pasta.mkdirs();			
		}
		File foto = new File(pasta.getAbsolutePath() + "\\" + "col-"+id + ".jpg");

		file.transferTo(foto); // pega o arquivo do MultipartFile e armazena do File

		Colaborador colaborador = buscarPorId(id);
		colaborador.setFoto34("/images/colaborador/" + "col-"+id + ".jpg");
		salvaObj(colaborador);
		
	}
}
