package br.com.san.apirestunittests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.san.apirestunittests.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
