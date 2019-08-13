package com.cadastrodeprodutos.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import com.cadastrodeprodutos.domain.Produto;
import com.cadastrodeprodutos.event.RecursoCriadoEvent;
import com.cadastrodeprodutos.services.ProdutosService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutosResource {
	
	@Autowired
	private ProdutosService produtosService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(produtosService.buscarTodos());
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscar(@PathVariable("codigo") Long codigo){
		Produto produto = produtosService.buscarPeloCodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	@PostMapping
	public ResponseEntity<Produto> salvarCliente(@RequestBody Produto produto, HttpServletResponse response){
		Produto produtoSalvo = produtosService.salvar(produto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> atualizar(@RequestBody Produto produto, @PathVariable("codigo") Long codigo){
		produto.setCodigo(codigo);
		produtosService.atualizar(produto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> apagar(@PathVariable("codigo") Long codigo){
		produtosService.deletar(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}






