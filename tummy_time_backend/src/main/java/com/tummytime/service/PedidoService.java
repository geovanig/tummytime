package com.tummytime.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tummytime.dto.PedidoDTO;
import com.tummytime.model.Pedido;
import com.tummytime.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Transactional(readOnly = true)
	public List<PedidoDTO> findAll() {
		List<Pedido> lista = repository.FindPedidoComProduto();
		return lista.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
	}
	
}
