package com.example.atest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atest.dao.TransactionDAOImpl;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionDAOImpl transactionDAOImpl;

	@Override
	public Double getTotalExpense(Integer id) {
		return transactionDAOImpl.getTotalExpense(id);
	}

	@Override
	public Double getTotalIncome(Integer id) {
		return transactionDAOImpl.getTotalIncome(id);
	}



	

}
