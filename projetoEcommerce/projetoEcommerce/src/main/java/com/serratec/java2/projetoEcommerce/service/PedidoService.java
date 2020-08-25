package com.serratec.java2.projetoEcommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
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
		
		
		
		public void inserirPedido(PedidoForm pedidoForm) throws ParametroObrigatorioException {
			if(pedidoForm == null) throw new ParametroObrigatorioException("Campo 'pedido' é obrigatório");
			Pedido pedido = new Pedido();
			ProdutoPedido pp = new ProdutoPedido();
			Optional<Cliente> opC = clienteRepository.findById(pedidoForm.getCodigo_cliente());
			Cliente cliente = new Cliente();
			cliente = opC.get();
			Double valorTotal = 0.0;
			
			//Para pedido
			pedido.setData_pedido(pedidoForm.getData_pedido());
			pedido.setCliente(cliente);
			
			//Para ProdutoPedido
			pp.setPedido(pedido);
			Optional<Produto> opProduto = produtoRepository.findById(pedidoForm.getCodigo_produto());
			Produto produto = opProduto.get();
			pp.setProduto(produto);
			pp.setQuantidade_itens(pedidoForm.getQuantidade_item());

			//Para o calculo
			Double vU = produto.getValor_unitario();
			valorTotal += vU * pedidoForm.getQuantidade_item();
			pedido.setValor_total(valorTotal);
			
			pedidoRepository.save(pedido);
			produtoPedidoRepository.save(pp);
		}
		
		
		
		
		public void deletarPedido(Integer id) throws pedidoNotFoundException {
			Optional<Pedido> opPedido = pedidoRepository.findById(id);
			if(opPedido.isEmpty()) {
				throw new pedidoNotFoundException("Endereço com id " + id + " não encontrado.");
			}
			Pedido pedido = opPedido.get();
			pedidoRepository.delete(pedido);
			
			
		}

		public PedidoForm listarPedidoPorId(Integer id) throws pedidoNotFoundException {
			Optional<Pedido> opPedido = pedidoRepository.findById(id);
			if(opPedido.isEmpty()) {
				throw new pedidoNotFoundException("Endereço com id " + id + " não encontrado.");
			}
			Pedido p = opPedido.get();
			Cliente cliente = p.getCliente();
			PedidoForm pForm = new PedidoForm();
			pForm.setCliente_nome(cliente.getNome());
			pForm.setCodigo(p.getCodigo());
			pForm.setCodigo_cliente(cliente.getCodigo());
			pForm.setData_pedido(p.getData_pedido());
			pForm.setValor_total(p.getValor_total());
			List<ProdutoPedido> ppList = new ArrayList();
			ppList = p.getListPedidoProduto();
			
			List<ProdutoPedidoForm> ppfList = new ArrayList<>();
			for(int i = 0; i < ppList.size(); i++) {
				ProdutoPedido pp = ppList.get(i);
				ProdutoPedidoForm ppForm = new ProdutoPedidoForm();
				Produto produto = pp.getProduto();
				ppForm.setCodigo_produto(produto.getCodigo());
				ppForm.setProduto_nome(produto.getNome());
				ppForm.setQuantidade_itens(pp.getQuantidade_itens());
				ppForm.setValor_unitario(produto.getValor_unitario());
				ppfList.add(ppForm);
			}
			pForm.setProdutosPedidos(ppfList);
			
			return pForm;
		}

		public List<PedidoForm> listarPedido() {
			List<Pedido> peList = pedidoRepository.findAll();
			List<PedidoForm> peFormList = new ArrayList<>();
			
			for(int i = 0; i< peList.size(); i++) {
				Pedido pedido = peList.get(i);
				PedidoForm peForm = new PedidoForm();
				Cliente cliente = new Cliente();
				ProdutoPedido pp = new ProdutoPedido();
				cliente = pedido.getCliente();
				peForm.setCodigo_cliente(cliente.getCodigo());
				peForm.setCliente_nome(cliente.getNome());
				peForm.setData_pedido(pedido.getData_pedido());
				peForm.setValor_total(pedido.getValor_total());
				Integer codPed = pedido.getCodigo();
				peForm.setCodigo(codPed);
				
				
				List<ProdutoPedido> ppOutraLista = new ArrayList<>() ;
				ppOutraLista = produtoPedidoRepository.findAll();
				
				for(int k = 0; k < ppOutraLista.size(); k++) {
					Pedido pedido1 = new Pedido();
					pedido1 = ppOutraLista.get(k).getPedido();
					if(pedido1.getCodigo() == codPed) {
						pp = ppOutraLista.get(k);
					}
				}
				
				
				for(int j = 0; j < ppOutraLista.size(); j++) {
					List<ProdutoPedidoForm> ppFList = new ArrayList<>();
					ProdutoPedidoForm ppForm = new ProdutoPedidoForm();
					Produto produto = new Produto();
					produto = pp.getProduto();
					Integer codProd = produto.getCodigo();
					String nome = produto.getNome();
					Integer qtd = pp.getQuantidade_itens();
					ppForm.setCodigo_produto(codProd);
					ppForm.setProduto_nome(nome);
					ppForm.setQuantidade_itens(qtd);
					ppForm.setValor_unitario(produto.getValor_unitario());
					
					ppFList.add(ppForm);
	
					peForm.setProdutosPedidos(ppFList);
				}
				
				peFormList.add(peForm);
			}
			
			return peFormList;
		}



}
