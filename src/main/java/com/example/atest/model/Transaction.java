package com.example.atest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "transactions")
public class Transaction {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String operation;
		private double amount;
		private String type;
		private String date_tx;
		
		
		@ManyToOne 
		private Account account;
		
		
		
		public Integer getId() {
			return id;
		}
		public String getOperation() {
			return operation;
		}
		public double getAmount() {
			return amount;
		}
		public String getType() {
			return type;
		}
		public String getDate_tx() {
			return date_tx;
		}
		public Account getAccount() {
			return account;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public void setOperation(String operation) {
			this.operation = operation;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public void setType(String type) {
			this.type = type;
		}
		public void setDate_tx(String date_tx) {
			this.date_tx = date_tx;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		
		@Override
		public String toString() {
			return "Transaction [id=" + id + ", operation=" + operation + ", amount=" + amount + ", type=" + type
					+ ", date_tx=" + date_tx + "]";
		}

}
