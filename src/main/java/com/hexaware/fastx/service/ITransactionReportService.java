package com.hexaware.fastx.service;

import com.hexaware.fastx.dto.TransactionReportDTO;
import com.hexaware.fastx.model.TransactionReport;

public interface ITransactionReportService {
	
	public TransactionReportDTO getReport(Long id);
	
	public TransactionReportDTO makeReport(TransactionReport report);
	
}
