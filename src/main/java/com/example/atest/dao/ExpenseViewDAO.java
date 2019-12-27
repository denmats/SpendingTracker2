package com.example.atest.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.atest.model.ExpenseView;


@Repository
public interface ExpenseViewDAO extends JpaRepository<ExpenseView, String>{
	
	@Query(
			value="select operation, sum(amount) as sum, account_account_id  from transactions where type='expense' and account_account_id= :id group by operation order by sum desc",
			nativeQuery=true)
	Set<ExpenseView> findAllExpenses(@Param("id") Integer id);
	
}
