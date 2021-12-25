package com.tummytime.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String endereco;
	private String latitude;
	private String longitude;
	private Instant momento;
	private StatusPedido status;
	
	@ManyToMany
	@JoinTable(name = "pedido_produto",
			joinColumns = @JoinColumn(name = "pedido_id"),
			inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private Set<Produto> produtos = new HashSet<>();
	
	public Pedido() {}

	public Pedido(long id, String endereco, String latitude, String longitude, Instant momento, StatusPedido status) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.momento = momento;
		this.status = status;
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
	public void setLongitude(String logitude) {
		this.longitude = logitude;
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

	public Set<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return id == other.id;
	}	
	
}
