package com.cadastrodeprodutos.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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

import com.cadastrodeprodutos.domain.Categoria;
import com.cadastrodeprodutos.domain.Produto;
import com.cadastrodeprodutos.event.RecursoCriadoEvent;
import com.cadastrodeprodutos.services.CategoriasService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResource {
	
	@Autowired
	private CategoriasService categoriasService;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listarCategorias(){
		return ResponseEntity.status(HttpStatus.OK).body(categoriasService.buscarTodos());
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable("codigo") Long codigo){
		return ResponseEntity.status(HttpStatus.OK).body(categoriasService.buscarPeloCodigo(codigo));
	}
	@GetMapping("/{codigo}/produtos")
	public ResponseEntity<List<Produto>> buscarProdutosPorCodigoCategoria(@PathVariable("codigo") Long codigo){
		return ResponseEntity.status(HttpStatus.OK).body(categoriasService.buscarProdutosPeloCodigoCategoria(categoriasService.buscarPeloCodigo(codigo)));
	}
	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriasService.salvar(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> atualizarCategoria(@PathVariable("codigo") Long codigo, @RequestBody Categoria categoria){
		categoria.setCodigo(codigo);
		categoriasService.atualizar(categoria);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable("codigo") Long codigo){
		categoriasService.deletar(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
} 
