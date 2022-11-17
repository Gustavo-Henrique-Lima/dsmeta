package com.gustavonascimento.dsmeta.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.dsmeta.dominio.Vendas;
import com.gustavonascimento.dsmeta.servicos.ServicosVendas;

@RestController
@RequestMapping(value="/vendas")
public class ControllerVendas {

	@Autowired
	private ServicosVendas servVendas;
	
	@GetMapping
	public List<Vendas> encontrarVendas()
	{
		return servVendas.todasAsVendas();
	}
}