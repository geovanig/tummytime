package com.tummytime.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tummytime.dto.PedidoDTO;
import com.tummytime.dto.ProdutoDTO;
import com.tummytime.model.Pedido;
import com.tummytime.model.Produto;
import com.tummytime.model.StatusPedido;
import com.tummytime.repository.PedidoRepository;
import com.tummytime.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(readOnly = true)
	public List<PedidoDTO> findAll() {
		List<Pedido> lista = repository.FindPedidoComProduto();
		return lista.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public PedidoDTO inserirPedido(PedidoDTO dto) {
		Pedido pedido = new Pedido(dto.getId(), dto.getEndereco(), dto.getLatitude(), dto.getLongitude(), Instant.now(),
				StatusPedido.PENDENTE);
		for (ProdutoDTO p : dto.getProduto()) {
			@SuppressWarnings("deprecation")
			Produto produto = produtoRepository.getOne(p.getId());
			pedido.getProduto().add(produto);
		}
		pedido = repository.save(pedido);
		return new PedidoDTO(pedido);
	}
}
