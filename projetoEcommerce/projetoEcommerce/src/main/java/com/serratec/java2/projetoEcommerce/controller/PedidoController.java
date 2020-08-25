package com.serratec.java2.projetoEcommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.exceptions.pedidoNotFoundException;
import com.serratec.java2.projetoEcommerce.forms.PedidoForm;
import com.serratec.java2.projetoEcommerce.models.Pedido;
import com.serratec.java2.projetoEcommerce.models.ProdutoPedido;
import com.serratec.java2.projetoEcommerce.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

//		inserir/atualizar/deletar pedidos
	
//		gerar nota fiscal
//		**forma de pagamento
	//calcular valor total do pedido
		
	@Autowired
	PedidoService pedidoService;

	List<ProdutoPedido> listaPP = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<Void> inserirPedido(@RequestBody(required = false) PedidoForm pedido) throws ParametroObrigatorioException{
		pedidoService.inserirPedido(pedido);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoForm> listarPedidoPorId(@PathVariable Integer id) throws pedidoNotFoundException{
		PedidoForm pedido = pedidoService.listarPedidoPorId(id); 
		return new ResponseEntity<PedidoForm>(pedido, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<List<PedidoForm>> listarPedidos(){
		return new ResponseEntity<List<PedidoForm>>(pedidoService.listarPedido(), HttpStatus.OK);
	}
	 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPedido(@PathVariable Integer id) throws pedidoNotFoundException{
		pedidoService.deletarPedido(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
