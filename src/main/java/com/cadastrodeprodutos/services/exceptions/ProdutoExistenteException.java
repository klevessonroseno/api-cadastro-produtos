package com.cadastrodeprodutos.services.exceptions;

public class ProdutoExistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8509563264126859005L;
	
	public ProdutoExistenteException(String mensagem) {
		super(mensagem);
	}
	public ProdutoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
