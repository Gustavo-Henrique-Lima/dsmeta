package com.gustavonascimento.dsmeta.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.dsmeta.dominio.Vendas;
import com.gustavonascimento.dsmeta.repositorios.RepositorioVendas;

@Service
public class ServicosVendas {
	
	@Autowired
	public RepositorioVendas repoVendas;
	
	
	public List<Vendas> todasAsVendas()
	{
			return repoVendas.findAll();
	}
}
