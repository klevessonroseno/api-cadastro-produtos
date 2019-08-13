package com.cadastrodeprodutos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrodeprodutos.domain.Produto;
import com.cadastrodeprodutos.repository.ProdutosRepository;
import com.cadastrodeprodutos.services.exceptions.ProdutoExistenteException;
import com.cadastrodeprodutos.services.exceptions.ProdutoNaoEncontradoException;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	public List<Produto> buscarTodos(){
		return produtosRepository.findAll();
	}
	public Produto buscarPeloCodigo(Long codigo) {
		Produto produto = produtosRepository.findOne(codigo);
		if(produto == null) {
			throw new ProdutoNaoEncontradoException("Produto não encontrado");
		}		
		return produto;
	}
	public Produto salvar(Produto produto) {
		if(produto.getCodigo() != null) {
			Produto produtoBuscado = produtosRepository.findOne(produto.getCodigo());
			if(produtoBuscado != null) {
				throw new ProdutoExistenteException("Produto já existente");
			}
		}
		return produtosRepository.save(produto);
	}
	private void verificarExistencia(Produto produto) {
		buscarPeloCodigo(produto.getCodigo());
	}
	public void atualizar(Produto produto) {
		verificarExistencia(produto);
		produtosRepository.save(produto);
	}
	public void deletar(Long codigo) {
		try {
			produtosRepository.delete(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new ProdutoNaoEncontradoException("Produto não encontrado.");
		}
	}

}
