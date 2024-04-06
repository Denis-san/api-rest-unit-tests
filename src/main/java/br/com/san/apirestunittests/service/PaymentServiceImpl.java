package br.com.san.apirestunittests.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.san.apirestunittests.domain.Payment;
import br.com.san.apirestunittests.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public void insert(Payment payment) {
		paymentRepository.save(payment);
	}


}
