package com.hexaware.fastx.service;

import com.hexaware.fastx.dto.RefundDTO;
import com.hexaware.fastx.model.Refund;

public interface IRefundService {

	public RefundDTO refundAmount(Refund refund);
	
}
