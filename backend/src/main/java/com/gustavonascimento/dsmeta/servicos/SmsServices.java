package com.gustavonascimento.dsmeta.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gustavonascimento.dsmeta.dominio.Vendas;
import com.gustavonascimento.dsmeta.repositorios.RepositorioVendas;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServices {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private RepositorioVendas vendaRepo;
	
	public void sendSms(Long idDaVenda) {
		Vendas venda=vendaRepo.findById(idDaVenda).get();
		String date=venda.getDate().getMonthValue()+" / "+venda.getDate().getYear();
		String msg="O vendedor "+venda.getSellerName()+" foi destaque em "+date
				+"com um total de R$ "+String.format("%.2f",venda.getAmount())+" em vendas.";
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}