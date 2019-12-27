package com.example.atest.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import com.example.atest.model.ExpenseView;

public class ExpenseViewDAOImpl {

	@Autowired
	ExpenseViewDAO expenseViewDAO;
	
	
	public Set<ExpenseView> findAllExpenses(@Param("id") Integer id){
		return expenseViewDAO.findAllExpenses(id);
	}
	
}
