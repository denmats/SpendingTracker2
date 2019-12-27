package com.example.atest.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atest.dao.ExpenseViewDAOImpl;
import com.example.atest.model.ExpenseView;


@Service
public class ExpenseViewServiceImpl implements ExpenseViewService {
	
	@Autowired
	ExpenseViewDAOImpl expenseViewDAOImpl;

	@Override
	public Set<ExpenseView> findAllExpenses(Integer id) {
		return expenseViewDAOImpl.findAllExpenses(id);
	}

}
