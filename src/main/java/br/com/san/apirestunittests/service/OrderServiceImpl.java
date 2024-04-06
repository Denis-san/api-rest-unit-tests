package br.com.san.apirestunittests.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.san.apirestunittests.domain.Order;
import br.com.san.apirestunittests.domain.OrderItem;
import br.com.san.apirestunittests.domain.PaymentWithTicket;
import br.com.san.apirestunittests.domain.enums.PaymentStatus;
import br.com.san.apirestunittests.repository.OrderItemRepository;
import br.com.san.apirestunittests.repository.OrderRepository;
import br.com.san.apirestunittests.service.exceptions.ObjectNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private OrderItemRepository itemRepository;

	@Override
	public Order findById(Integer id) {
		Optional<Order> optOrder = orderRepository.findById(id);
		return optOrder.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! id: " + id + ", Type: " + Order.class.getName()));
	}

	@Override
	public Order insert(Order order) {
		order.setId(null);
		order.setInstant(new Date());
		
		order.getPayment().setPaymentStatus(PaymentStatus.PENDING);
		order.getPayment().setOrder(order);
		
		if(order.getPayment() instanceof PaymentWithTicket) {
			PaymentWithTicket paymnt = (PaymentWithTicket) order.getPayment();
			ticketService.fillPaymentWithTicket(paymnt, order.getInstant());
		}
		
		order = orderRepository.save(order);
		paymentService.insert(order.getPayment());
		
		for(OrderItem item : order.getItems()) {
			item.setDiscount(0.0);
			item.setPrice(productService.findById(item.getProduct().getId()).getPrice());
			item.setOrder(order);
		}
		
		itemRepository.saveAll(order.getItems());
		
		return order;
	}

}
