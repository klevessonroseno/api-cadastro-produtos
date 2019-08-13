package com.cadastrodeprodutos.services.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4065583763872792411L;
	
	public ProdutoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	public ProdutoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
