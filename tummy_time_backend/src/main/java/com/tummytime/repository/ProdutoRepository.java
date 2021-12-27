package com.tummytime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tummytime.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findAllByOrderByNomeAsc();
	
}
