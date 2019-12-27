package com.example.atest.service;

import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.example.atest.model.ExpenseView;

public interface ExpenseViewService {
	
	Set<ExpenseView> findAllExpenses(@Param("id") Integer id);

}
