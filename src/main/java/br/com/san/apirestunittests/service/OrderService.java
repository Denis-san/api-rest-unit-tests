package br.com.san.apirestunittests.service;

import br.com.san.apirestunittests.domain.Order;

public interface OrderService {

	public Order findById(Integer id);

	public Order insert(Order order);

}
