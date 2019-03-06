package maiati.comercial.service.compras;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maiati.comercial.model.compras.CompraCotacao;
import maiati.comercial.model.compras.CompraCotacaoDetalhe;
import maiati.comercial.model.compras.CompraFornecedorCotacao;
import maiati.comercial.model.compras.CompraReqCotacaoDetalhe;
import maiati.comercial.repository.compras.CompraContacaoRepository;

/**
 * @author Dowglas Maia
 */

@Service
public class CompraCotacaoService {

	@Autowired
	private CompraContacaoRepository repository;

	/* Listar Todos */
	public List<CompraCotacao> listarTodos() {
		return repository.findAll();
	}

	/* Buscar por ID */
	public CompraCotacao buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

	/* Salvar */
	public CompraCotacao salvaObj(CompraCotacao obj) {
		
		/* Realizando Laços entre as Entidades que compoem a Compra Cotaçao */
		for (CompraFornecedorCotacao cf : obj.getListaCompraFornecedorCotacao()) {
			cf.setCompraCotacao(obj);
			
			if(cf.getListaCompraCotacaoDetalhe() == null) {
				cf.setListaCompraCotacaoDetalhe(new HashSet<>());
			}

			for (CompraReqCotacaoDetalhe cr : obj.getListaCompraReqCotacaoDetalhes()) {
				cr.setCompraCotacao(obj);

				CompraCotacaoDetalhe cotacaoDetalhe = new CompraCotacaoDetalhe();
				cotacaoDetalhe.setCompraFornecedorCotacao(cf);
				cotacaoDetalhe.setProduto(cr.getCompraRequisicaoDetalhe().getProduto());
				cotacaoDetalhe.setQuantidade(cr.getQuantidadeCotada());
				
			cf.getListaCompraCotacaoDetalhe().add(cotacaoDetalhe);
			}
		}
		return repository.save(obj);
	}

	
	
	/* Excluir */
	public void excluir(Integer id) {
		CompraCotacao obj = new CompraCotacao();
		obj.setId(id);
		repository.delete(obj);
	}
}
