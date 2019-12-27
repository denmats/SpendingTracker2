package com.example.atest.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer account_id;
	private String name;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Transaction> tx;

	public Integer getAccount_id() {
		return account_id;
	}

	public String getName() {
		return name;
	}

	public Set<Transaction> getTx() {
		return tx;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTx(Set<Transaction> tx) {
		this.tx = tx;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", name=" + name + ", tx=" + tx + "]";
	}
	
	

	
}
