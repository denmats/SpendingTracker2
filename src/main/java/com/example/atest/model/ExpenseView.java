package com.example.atest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "expense_view")
public class ExpenseView {

	@Id
	private String operation;
	private Double sum;
	private Integer account_account_id;
	
	public String getOperation() {
		return operation;
	}
	public Double getSum() {
		return sum;
	}
	public Integer getAccount_account_id() {
		return account_account_id;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public void setAccount_account_id(Integer account_account_id) {
		this.account_account_id = account_account_id;
	}
	@Override
	public String toString() {
		return "ExpenseView [operation=" + operation + ", sum=" + sum + ", account_account_id=" + account_account_id
				+ "]";
	}
	
	
	
}
