package com.cadastrodeprodutos.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cadastrodeprodutos.domain.DetalhesErro;
import com.cadastrodeprodutos.services.exceptions.CategoriaExistenteException;
import com.cadastrodeprodutos.services.exceptions.CategoriaNaoEncontradaException;
import com.cadastrodeprodutos.services.exceptions.ProdutoExistenteException;
import com.cadastrodeprodutos.services.exceptions.ProdutoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O produto não pôde ser encontrado.");
		erro.setMensagemDesenvolvedor("https://erros.cadastroprodutos.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(ProdutoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleProdutoExistenteException(ProdutoExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Produto já existente.");
		erro.setMensagemDesenvolvedor("https://erros.cadastroprodutos.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleCategoriaNaoEncontradaException(CategoriaNaoEncontradaException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("A categoria não pôde ser encontrada");
		erro.setMensagemDesenvolvedor("https://erros.cadastroprodutos.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(CategoriaExistenteException.class)
	public ResponseEntity<DetalhesErro> handleCategoriaExistenteException(CategoriaExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Categoria já existente.");
		erro.setMensagemDesenvolvedor("https://erros.cadastroprodutos.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("https://erros.cadastroprodutos.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
