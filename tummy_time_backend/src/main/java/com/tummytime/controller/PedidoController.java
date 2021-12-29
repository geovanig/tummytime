package com.tummytime.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tummytime.dto.PedidoDTO;
import com.tummytime.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity <List<PedidoDTO>> findAll(){
		List<PedidoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
}
