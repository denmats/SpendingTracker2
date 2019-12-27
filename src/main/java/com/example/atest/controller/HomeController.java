package com.example.atest.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.atest.dao.AccountDAO;
import com.example.atest.model.Account;
import com.example.atest.model.ExpenseView;
import com.example.atest.service.ExpenseViewServiceImpl;
import com.example.atest.service.TransactionServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	ExpenseViewServiceImpl expenseViewServiceImpl;
	
	@Autowired
	TransactionServiceImpl transactionServiceImpl;
	
	
	@RequestMapping("/")
	public String getLogin() {
	
		return "login";
	}
	
	
	@RequestMapping("home")
	public String home(@RequestParam("account_id") Integer id ,Model m) {
		Account currentAccount = accountDAO.getOne(id);
		m.addAttribute("account", currentAccount);
		
		Set<ExpenseView> list = expenseViewServiceImpl.findAllExpenses(id);	
		m.addAttribute("list", list);
		
		m.addAttribute("totalIncome", transactionServiceImpl.getTotalIncome(id));
		m.addAttribute("totalExpense", transactionServiceImpl.getTotalExpense(id));
		
		Double balance = transactionServiceImpl.getTotalIncome(id)-transactionServiceImpl.getTotalExpense(id);
		m.addAttribute("balance", balance);
		
		Double totalCashFlow = transactionServiceImpl.getTotalIncome(id)+transactionServiceImpl.getTotalExpense(id);
		m.addAttribute("progressBarIncomePercent", (transactionServiceImpl.getTotalIncome(id)/totalCashFlow)*100);
		m.addAttribute("progressBarExpensePercent", (transactionServiceImpl.getTotalExpense(id)/totalCashFlow)*100);
		
		return "index";
	}
	
	/**
	 * displaying pie chart in home page 
	 * pie chart is drawing, when the servlet
	 * redirects to index.jsp at that time, piechart.js is executing
	 */
	@RequestMapping("/piechart")
	public ResponseEntity<?> getPiechartData() {
		Set<ExpenseView> dataList = expenseViewServiceImpl.findAllExpenses(1);	
		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}

}
