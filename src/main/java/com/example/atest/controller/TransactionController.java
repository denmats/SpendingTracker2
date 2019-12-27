package com.example.atest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.atest.dao.AccountDAO;
import com.example.atest.dao.ExpenseViewDAO;
import com.example.atest.dao.TransactionDAO;
import com.example.atest.model.Account;
import com.example.atest.model.Transaction;


@Controller
public class TransactionController {
	

	@Autowired
	AccountDAO accountDAO;

	@Autowired
	TransactionDAO transactionDAO;
	
	@Autowired
	ExpenseViewDAO expenseViewDAO;
	
	
	
	
	@RequestMapping("getTransactions")
	public String selectOperation(@RequestParam("account_id") Integer id, Model m) {
		
		Account account = accountDAO.getOne(id);
		m.addAttribute("account", account);

		return "transactions";
	}
	
	
	@RequestMapping("addTransaction")
	public String addTransactions(@RequestParam("account_id") Integer id, @RequestParam("type") String type, Model m) {
		
		Account account = accountDAO.getOne(id);
		m.addAttribute("account", account);

		return type;
	}
	
	
	@RequestMapping("saveTransaction")
	public String saveTransactions(@RequestParam("account_account_id") Integer account_id, Transaction tx, Model m) {
		
		Account account = accountDAO.getOne(account_id);
		tx.setAccount(account);
		transactionDAO.save(tx);
		
		m.addAttribute("account", account);
		
		String message = "Record successfully saved!";
		m.addAttribute("message", message);
		
		return "transactions";
	}
	
	
	@RequestMapping("updateTransaction")
	public String updateTransactions(@RequestParam("account_account_id") Integer account_id, @RequestParam("id") Integer id, Model m) {
		
		Account account = accountDAO.getOne(account_id);
		Transaction transaction = transactionDAO.getOne(id);
			
		m.addAttribute("account", account);
		m.addAttribute("transaction", transaction);
		
		return transaction.getType();
	}
	
	
	@RequestMapping(value="deleteTransaction", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteTransaction(@RequestParam("id") Integer id, @RequestParam("account_id") Integer account_id, Model m) {
		
		Account account = accountDAO.getOne(account_id);
		m.addAttribute("account", account);
		
		transactionDAO.deleteById(id);
		
		String message = "Record successfully deleted!";
		m.addAttribute("message", message);
		
		return "transactions";
	}

}
