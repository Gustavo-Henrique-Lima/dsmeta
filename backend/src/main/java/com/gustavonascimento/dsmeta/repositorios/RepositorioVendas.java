package com.gustavonascimento.dsmeta.repositorios;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gustavonascimento.dsmeta.dominio.Vendas;

public interface RepositorioVendas extends JpaRepository<Vendas, Long>{
	
	@Query("SELECT obj FROM Vendas obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Vendas> todasAsVendas(LocalDate min, LocalDate max, Pageable pageable);
}	