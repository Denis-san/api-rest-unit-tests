package br.com.san.apirestunittests.service;

import java.util.Date;

import br.com.san.apirestunittests.domain.PaymentWithTicket;

public interface TicketService {

	void fillPaymentWithTicket(PaymentWithTicket paymnt, Date instant);

}
