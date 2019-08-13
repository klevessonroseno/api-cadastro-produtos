package com.cadastrodeprodutos.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message="O campo 'nome' não pode ser nulo.")
	@Size(max=100, message="O campo 'nome' não pode conter mais do que 100 caracteres.")
	private String nome;
	
	@Size(max=200, message="O campo 'descricao' não pode conter mais do que 200 caracteres.")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", targetEntity=Produto.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Produto> produtos;

	public Categoria(String nome, String descricao, List<Produto> produtos) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.produtos = produtos;
	}
	
	public Categoria() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
