package com.company.data;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.entity.Transaction;

@Service
public class FakeTransactions {

	private HashMap<String, List<Transaction>> transactionRecords = new HashMap<>();
	
	public FakeTransactions() {
		buildFakeTransactions();
	}
	
	public List<Transaction> getTransactions(String email) {
		
		return transactionRecords.get(email);
	}
	
	private void buildFakeTransactions() {
		
		List<Transaction> transactions = new ArrayList<>();
		
		transactions.add(new Transaction(LocalDate.of(2021,Month.AUGUST,1), 55.00, 1));
		transactions.add(new Transaction(LocalDate.of(2021,Month.AUGUST,31), 45.00, 1));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,1), 250.25, 1));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,15), 125.12, 1));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,30), 20.00, 1));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,1), 1125.23, 1));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,15), 63.25, 1));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,31), 45.32, 1));
		
		transactionRecords.put("email1@email.com", transactions);
		transactions = new ArrayList<>();
		
		transactions.add(new Transaction(LocalDate.of(2021,Month.AUGUST,1), 55.00, 2));
		transactions.add(new Transaction(LocalDate.of(2021,Month.AUGUST,15), 120.50, 2));
		transactions.add(new Transaction(LocalDate.of(2021,Month.AUGUST,31), 45.00, 2));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,1), 250.25, 2));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,15), 125.12, 2));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,30), 20.00, 2));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,15), 63.25, 2));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,31), 45.32, 2));
		
		transactionRecords.put("email2@email.com", transactions);
		transactions = new ArrayList<>();

		transactions.add(new Transaction(LocalDate.of(2021,Month.AUGUST,31), 45.00, 3));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,1), 250.25, 3));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,15), 125.12, 3));
		transactions.add(new Transaction(LocalDate.of(2021,Month.SEPTEMBER,30), 20.00, 3));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,1), 1125.23, 3));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,15), 63.25, 3));
		transactions.add(new Transaction(LocalDate.of(2021,Month.OCTOBER,31), 45.32, 3));
		
		transactionRecords.put("email3@email.com", transactions);

	}
}
