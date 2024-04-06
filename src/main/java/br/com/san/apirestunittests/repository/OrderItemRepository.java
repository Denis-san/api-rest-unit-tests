package br.com.san.apirestunittests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.san.apirestunittests.domain.OrderItem;
import br.com.san.apirestunittests.domain.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
