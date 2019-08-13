package com.cadastrodeprodutos.services.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 280132259150002705L;
	
	public CategoriaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	public CategoriaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
