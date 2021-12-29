package com.tummytime.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.tummytime.model.Pedido;
import com.tummytime.model.StatusPedido;

public class PedidoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String endereco;
	private String latitude;
	private String longitude;
	private Instant momento;
	private StatusPedido status;
	
	private List<ProdutoDTO> produto = new ArrayList<>();
	
	public PedidoDTO() {}

	public PedidoDTO(long id, String endereco, String latitude, String longitude, Instant momento, StatusPedido status) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.momento = momento;
		this.status = status;
	}
	
	public PedidoDTO(Pedido entidade) {
		id = entidade.getId();
		endereco = entidade.getEndereco();
		latitude = entidade.getLatitude();
		longitude = entidade.getLongitude();
		momento = entidade.getMomento();
		status = entidade.getStatus();
		produto = entidade.getProdutos().stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Instant getMomento() {
		return momento;
	}
	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ProdutoDTO> getProduto() {
		return produto;
	}
	
}
