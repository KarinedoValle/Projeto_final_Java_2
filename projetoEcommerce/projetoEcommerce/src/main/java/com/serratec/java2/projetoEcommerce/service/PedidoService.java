package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.models.Pedido;
import com.serratec.java2.projetoEcommerce.models.ProdutoPedido;
import com.serratec.java2.projetoEcommerce.repository.PedidoRepository;

@Service
public class PedidoService {

//		inserir/atualizar/deletar pedidos
//		gerar nota fiscal
//		**forma de pagamento
		
		@Autowired
		PedidoRepository pedidoRepository;
		
		public void inserirPedido(Pedido pedido) {
			pedidoRepository.save(pedido);
			
		}
		
		public void deletarPedido(Integer id) {
			Pedido pedido = listarPedidoPorId(id);
			pedidoRepository.delete(pedido);
			
		}

		public Pedido listarPedidoPorId(Integer id) {
			Optional<Pedido> opPedido = pedidoRepository.findById(id);
		
			if(opPedido.isPresent()) {
				Pedido pedido = opPedido.get();
				return pedido;
			}
			return null;
			//throw new pedidoNotFoundException("Endereço com id " + id + " não encontrado.");
		}

		public List<Pedido> listarPedido() {
			return pedidoRepository.findAll();
		}

//		public void calcularValorTotal(Integer id) {
//			Optional<Pedido> opPedido = pedidoRepository.findById(id);
//			Pedido pedido = opPedido.get();
//			
//			pedido.getCodigo_produto();
//			ProdutoPedido produto = listarProdutoPorId(id); 
//			pedido.getQuantidade_itens() * pedido.get
//
//
//			pedido.setValor_total(valor);
//			
//		}
		
		public Pedido substituir(Integer id, Pedido pedido) {
			
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
			
			return novoPedido;
			
	}

}
