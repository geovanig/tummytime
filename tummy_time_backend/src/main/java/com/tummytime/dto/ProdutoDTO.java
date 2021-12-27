package com.tummytime.dto;

import java.io.Serializable;

import com.tummytime.model.Produto;

public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nome;
	private double preco;
	private String descricao;
	private String imagem;

	public ProdutoDTO() {}

	public ProdutoDTO(long id, String nome, double preco, String descricao, String imagem) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imagem = imagem;
	}
	
	public ProdutoDTO(Produto entidade) {
		id = entidade.getId();
		nome = entidade.getNome();;
		preco = entidade.getPreco();;
		descricao = entidade.getDescricao();
		imagem = entidade.getImagem();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
