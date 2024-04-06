package br.com.san.apirestunittests.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.san.apirestunittests.domain.enums.PaymentStatus;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("paymentWithCard")
public class PaymentWithCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer numberOfInstallments;

	public PaymentWithCard() {

	}

	public PaymentWithCard(Integer id, PaymentStatus paymentStatus, Order order, Integer numberOfInstallments) {
		super(id, paymentStatus, order);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

}
