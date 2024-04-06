package br.com.san.apirestunittests.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.san.apirestunittests.domain.enums.PaymentStatus;
import jakarta.persistence.Entity;

@Entity
@JsonTypeName("paymentWithTicket")
public class PaymentWithTicket extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date paymentDate;

	public PaymentWithTicket() {

	}

	public PaymentWithTicket(Integer id, PaymentStatus paymentStatus, Order order, Date dueDate, Date paymentDate) {
		super(id, paymentStatus, order);

		this.dueDate = dueDate;
		this.paymentDate = paymentDate;

	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
