package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.pedidoNotFoundException;
import com.serratec.java2.projetoEcommerce.models.Pedido;
import com.serratec.java2.projetoEcommerce.models.Produto;
import com.serratec.java2.projetoEcommerce.models.ProdutoPedido;
import com.serratec.java2.projetoEcommerce.repository.PedidoRepository;
import com.serratec.java2.projetoEcommerce.repository.ProdutoPedidoRepository;
import com.serratec.java2.projetoEcommerce.repository.ProdutoRepository;

@Service
public class PedidoService {

//		inserir/atualizar/deletar pedidos
//		gerar nota fiscal
//		**forma de pagamento
		
		@Autowired
		PedidoRepository pedidoRepository;
		@Autowired
		ProdutoRepository produtoRepository;
		@Autowired
		ProdutoPedidoRepository produtoPedidoRepository;
		
		public void inserirPedido(Pedido pedido, ProdutoPedido pp, List<ProdutoPedido> listaPP) {
			pedidoRepository.save(pedido);
			listaPP.add(pp);
			produtoPedidoRepository.saveAll(listaPP);
			
		}
		
		public void deletarPedido(Integer id) throws pedidoNotFoundException {
			Pedido pedido = listarPedidoPorId(id);
			pedidoRepository.delete(pedido);
			
		}

		public Pedido listarPedidoPorId(Integer id) throws pedidoNotFoundException {
			Optional<Pedido> opPedido = pedidoRepository.findById(id);
		
			if(opPedido.isPresent()) {
				Pedido pedido = opPedido.get();
				return pedido;
			}
			throw new pedidoNotFoundException("Endereço com id " + id + " não encontrado.");
		}

		public List<Pedido> listarPedido() {
			return pedidoRepository.findAll();
		}

//		public void calcularValorTotal(Integer id) {
//			List<ProdutoPedido> listaPP = produtoPedidoRepository.findByCodigo_pedido(id);
//			List<Produto> listaProd = produtoRepository.findAll();
//			Pedido p = null;
//			
//			for(int i = 0; i < listaPP.size(); i++) {
////				Integer codProd = listaPP.get(i);
//			}
//		}
		
		public Pedido substituir(Integer id, Pedido pedido, ProdutoPedido pp) throws pedidoNotFoundException {
			
			Pedido pedidoNoBanco = listarPedidoPorId(id);
			
			if (pedido.getData_pedido() != null) {
				pedidoNoBanco.setData_pedido(pedido.getData_pedido());
			}

			//Trazer o cálculo para o valor total
			if (pedido.getValor_total() != null) {
				pedidoNoBanco.setValor_total(pedido.getValor_total());
			}

//			if (pedido.getCodigo_cliente() != null) {
//				pedidoNoBanco.setCodigo_cliente(pedido.getCodigo_cliente());
//			}
			
			Pedido novoPedido = pedidoRepository.save(pedidoNoBanco);
			
			List<ProdutoPedido> PP = produtoPedidoRepository.findByCodigo_pedido(id);
			
//			if(pp.getQuantidade_itens() != null) {
//				ppNoDB.setQuantidade_itens(pp.getQuantidade_itens());
//			}
//			
//			produtoPedidoRepository.save(ppNoDB);
			
			return novoPedido;
			
	}

		public List<ProdutoPedido> listarTudoDoPedido(Integer id) throws pedidoNotFoundException {
			return produtoPedidoRepository.findByCodigo_pedido(id);
		}

}
