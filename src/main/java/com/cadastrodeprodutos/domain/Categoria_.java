package com.cadastrodeprodutos.domain;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;



@Generated(value="org.hibernate.jpametamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {
	
	public static volatile SingularAttribute<Categoria, Long> codigo;
	public static volatile SingularAttribute<Categoria, String> nome;
	public static volatile SingularAttribute<Categoria, String> descricao;
	public static volatile SingularAttribute<Categoria, List<Produto>> produtos;
}
