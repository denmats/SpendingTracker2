package com.example.atest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

public class TransactionDAOImpl {
	
	@Autowired
	TransactionDAO transactionDAO;
	
	
	public Double getTotalExpense(@Param("id") Integer id) {
		return transactionDAO.getTotalExpense(id);
	}
	
	
	public Double getTotalIncome(@Param("id") Integer id) {
		return transactionDAO.getTotalIncome(id);
	}
	
	

	
	
	
	

}
