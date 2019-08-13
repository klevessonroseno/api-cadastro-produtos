package com.cadastrodeprodutos.domain;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.hibernate.jpametamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {
	
	public static volatile SingularAttribute<Categoria, Long> codigo;
	public static volatile SingularAttribute<Categoria, String> nome;
	public static volatile SingularAttribute<Categoria, BigDecimal> preco;
	public static volatile SingularAttribute<Categoria, Long> quantidade;
	public static volatile SingularAttribute<Categoria, Categoria> categoria;
}
