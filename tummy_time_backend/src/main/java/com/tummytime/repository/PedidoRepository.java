package com.tummytime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tummytime.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
