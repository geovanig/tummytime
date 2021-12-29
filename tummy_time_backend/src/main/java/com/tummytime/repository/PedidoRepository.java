package com.tummytime.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tummytime.model.Pedido;
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query("SELECT DISTINCT obj "
			+ "FROM Pedido obj "
			+ "JOIN FETCH obj.produto "
			+ "WHERE obj.status = 0 "
			+ "ORDER BY obj.momento ASC")
	List<Pedido> FindPedidoComProduto();
	
}
