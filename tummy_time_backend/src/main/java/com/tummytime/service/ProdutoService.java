package com.tummytime.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tummytime.dto.ProdutoDTO;
import com.tummytime.model.Produto;
import com.tummytime.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll() {
		List<Produto> lista = repository.findAllByOrderByNomeAsc();
		return lista.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}

}
