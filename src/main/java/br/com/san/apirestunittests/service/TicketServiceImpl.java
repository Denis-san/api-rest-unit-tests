package br.com.san.apirestunittests.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.san.apirestunittests.domain.PaymentWithTicket;

@Service
public class TicketServiceImpl implements TicketService{

	@Override
	public void fillPaymentWithTicket(PaymentWithTicket paymnt, Date instant) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(instant);
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		paymnt.setDueDate(calendar.getTime());
	}

}
