package br.com.san.apirestunittests.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.san.apirestunittests.domain.Order;
import br.com.san.apirestunittests.service.OrderService;
import br.com.san.apirestunittests.service.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@GetMapping("/{id}")
	public ResponseEntity<Order> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Order tempOrder = orderService.findById(id);
		return ResponseEntity.ok().body(tempOrder);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Order order) {
		orderService.insert(order);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(order.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}

}
