package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	
	@Query("SELECT t FROM Transaction t WHERE t.status = :status order by t.id")
	List<Transaction> getMailByStatus(@Param("status") String status);

	
}
