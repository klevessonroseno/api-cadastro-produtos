package com.cadastrodeprodutos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cadastrodeprodutos.domain.Categoria;
import com.cadastrodeprodutos.domain.Produto;
import com.cadastrodeprodutos.repository.CategoriasRepository;
import com.cadastrodeprodutos.services.exceptions.CategoriaExistenteException;
import com.cadastrodeprodutos.services.exceptions.CategoriaNaoEncontradaException;

@Service
public class CategoriasService {
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public List<Categoria> buscarTodos(){
		return categoriasRepository.findAll();
	}
	public Categoria buscarPeloCodigo(Long codigo) {
		Categoria categoriaBuscada = categoriasRepository.findOne(codigo);
		if(categoriaBuscada == null) {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada.");
		}		
		return categoriaBuscada;
	}
	public Categoria salvar(Categoria categoria) {
		if(categoria.getCodigo() != null) {
			Categoria categoriaBuscada = categoriasRepository.findOne(categoria.getCodigo());
			if(categoriaBuscada != null) {
				throw new CategoriaExistenteException("Cliente já existente.");
			}
		}
		return categoriasRepository.save(categoria);
	}
	private void verificarExistencia(Categoria categoria) {
		buscarPeloCodigo(categoria.getCodigo());
	}
	public void atualizar(Categoria categoria) {
		verificarExistencia(categoria);
		categoriasRepository.save(categoria);
	}
	public void deletar(Long codigo) {
		try {
			categoriasRepository.delete(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada.");
		}
	}
	public List<Produto> buscarProdutosPeloCodigoCategoria(Categoria categoria) {
		verificarExistencia(categoria);
		return categoria.getProdutos();
	}
}
