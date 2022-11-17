package com.gustavonascimento.dsmeta.servicos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gustavonascimento.dsmeta.dominio.Vendas;
import com.gustavonascimento.dsmeta.repositorios.RepositorioVendas;

@Service
public class ServicosVendas {
	
	@Autowired
	public RepositorioVendas repoVendas;
	
	
	public Page<Vendas> todasAsVendas(String minDate,String maxDate,Pageable pageable)
	{
			LocalDate hoje=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		    LocalDate min=minDate.equals("")?hoje.minusDays(365):LocalDate.parse(minDate);
		    LocalDate max=maxDate.equals("")?hoje:LocalDate.parse(maxDate);
			return repoVendas.todasAsVendas(min,max,pageable);
	}
}