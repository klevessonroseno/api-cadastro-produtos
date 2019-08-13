package com.cadastrodeprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastrodeprodutos.domain.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

}
