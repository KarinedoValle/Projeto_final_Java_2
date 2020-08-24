package com.serratec.java2.projetoEcommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.pedidoNotFoundException;
import com.serratec.java2.projetoEcommerce.forms.PedidoForm;
import com.serratec.java2.projetoEcommerce.forms.ProdutoPedidoForm;
import com.serratec.java2.projetoEcommerce.models.Cliente;
import com.serratec.java2.projetoEcommerce.models.Pedido;
import com.serratec.java2.projetoEcommerce.models.Produto;
import com.serratec.java2.projetoEcommerce.models.ProdutoPedido;
import com.serratec.java2.projetoEcommerce.repository.ClienteRepository;
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
		@Autowired
		ClienteRepository clienteRepository;
		
		public void inserirPedido(PedidoForm pedidoForm) {
			Pedido pedido = null;
			Double valorTotal = 0.0;
			List<ProdutoPedido> ppList = new ArrayList<>();
			ProdutoPedido pp = null;
			
			//Fazer a busca do cliente
			Integer codCliente = pedidoForm.getCodigo_cliente(); 
			Optional <Cliente> opCliente =  clienteRepository.findById(codCliente);
			Cliente cliente = opCliente.get();
			pedido.setCliente(cliente);
			
			//Data do Pedido
			pedido.setData_pedido(pedidoForm.getData_pedido());
			
			//Passar de form para produtoPedido
			for(int i = 0; i < pedidoForm.getProdutosPedidos().size(); i++) {
				
				ProdutoPedidoForm ppForm = pedidoForm.getProdutosPedidos().get(i);
				
				Integer codProd = ppForm.getCodigo_produto();
				Optional <Produto> opProd =  produtoRepository.findById(codProd);
				Produto produto = opProd.get();
				Double valorUnitario = produto.getValor_unitario();
				Integer qtItens = ppForm.getQuantidade_itens();
				
				Double subtotal = valorUnitario * qtItens;
				valorTotal +=  subtotal;
				
				pp.setProduto(produto);
				pp.setPedido(pedido);
				pp.setQuantidade_itens(qtItens);
				
				ppList.add(pp);
				produtoPedidoRepository.save(pp);
			}

			pedido.setListPedidoProduto(ppList);
			pedido.setValor_total(valorTotal);
			pedidoRepository.save(pedido);
			
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


}
