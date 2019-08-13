package com.cadastrodeprodutos.services.exceptions;

public class CategoriaExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7173846883146636370L;
	
	public CategoriaExistenteException(String mensagem) {
		super(mensagem);
	}
	public CategoriaExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
