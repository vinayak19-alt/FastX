package com.hexaware.fastx.service;

import com.hexaware.fastx.dto.PaymentsDTO;
import com.hexaware.fastx.model.Payments;

public interface IPaymentService {
	
	public PaymentsDTO makePayment(Payments payment);

}
