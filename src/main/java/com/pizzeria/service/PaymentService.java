package com.pizzeria.service;

import com.pizzeria.model.Order;
import com.pizzeria.model.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Order order) throws StripeException;

}
