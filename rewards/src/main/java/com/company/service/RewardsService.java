package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.data.FakeTransactions;
import com.company.entity.Transaction;

@Service
public class RewardsService {
	
	@Autowired
	FakeTransactions fakeTransactions;
	
	public Integer calculateTotalRewards(String email) {
		
		List<Transaction> allTransactions = fakeTransactions.getTransactions(email);
	
		Integer total = 0;
		
		for (Transaction transaction : allTransactions) {
		
			Integer transactionAmount = transaction.getTransactionAmount().intValue();
			
			if (transactionAmount > 50 && transactionAmount < 100) {
				total += transactionAmount - 50;
			}
			
			if (transactionAmount >= 100) {
				total += 50 + (transactionAmount - 100) * 2;
			}
		}
		
		return total;
	}
	
	public Integer calculateRewardsForMonth(String email, String month) {	

		List<Transaction> allTransactions = fakeTransactions.getTransactions(email);
		Integer total = 0;
		
		for (Transaction transaction : allTransactions) {
			
			if (transaction.getTransactionDate().getMonth().equals(month)) {
						
				Integer transactionAmount = transaction.getTransactionAmount().intValue();
				
				if (transactionAmount > 50 && transactionAmount < 100) {
					total += transactionAmount - 50;
				}
				
				if (transactionAmount >= 100) {
					total += 50 + (transactionAmount - 100) * 2;
				}
			}
		}
		
		return total;
	}

}
