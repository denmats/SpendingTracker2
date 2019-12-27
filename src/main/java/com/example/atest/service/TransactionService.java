package com.example.atest.service;

import org.springframework.data.repository.query.Param;

public interface TransactionService {
	
	Double getTotalExpense(@Param("id") Integer id);
	
	Double getTotalIncome(@Param("id") Integer id);

}
