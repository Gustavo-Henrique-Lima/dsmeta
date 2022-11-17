package com.gustavonascimento.dsmeta.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavonascimento.dsmeta.dominio.Vendas;

public interface RepositorioVendas extends JpaRepository<Vendas, Long>{

}