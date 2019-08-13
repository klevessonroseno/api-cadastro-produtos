package com.cadastrodeprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrodeprodutos.domain.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {

}
