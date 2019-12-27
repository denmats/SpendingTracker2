package com.example.atest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.atest.model.Transaction;


@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {
	
	
	@Query(
			value="select sum(amount) from transactions where type='income' and account_account_id= :id",
			nativeQuery=true)
	Double getTotalIncome(@Param("id") Integer id); 
	
	
	@Query(
			value="select sum(amount) from transactions where type='expense' and account_account_id= :id",
			nativeQuery=true)
	Double getTotalExpense(@Param("id") Integer id);

}
