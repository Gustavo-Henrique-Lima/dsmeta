package com.gustavonascimento.dsmeta.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.dsmeta.dominio.Vendas;
import com.gustavonascimento.dsmeta.servicos.ServicosVendas;
import com.gustavonascimento.dsmeta.servicos.SmsServices;

@RestController
@RequestMapping(value="/vendas")
public class ControllerVendas {

	@Autowired
	private ServicosVendas servVendas;
	@Autowired
	private SmsServices sms;
	
	@GetMapping
	public Page<Vendas> encontrarVendas(
			@RequestParam(value="minDate",defaultValue = "") String minDate,
			@RequestParam(value="maxDate",defaultValue = "")String maxDate,
			Pageable pageable)
	{
		return servVendas.todasAsVendas(minDate,maxDate,pageable);
	}
	@GetMapping("/{id}/notificacao")
	public void notificarSms(@PathVariable Long id)
	{
		sms.sendSms(id);
	}
}