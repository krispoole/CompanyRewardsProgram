package com.company.service;

import java.util.List;

import com.company.entity.Transaction;

public class RewardsService {
	
	public Integer calculateTotalRewards(List<Transaction> allTransactions) {
	
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
	
	public Integer calculateRewardsForMonth(List<Transaction> allTransactions, Integer month) {
		
		Integer total = 0;
		
		for (Transaction transaction : allTransactions) {
			
			if (transaction.getTransactionDate().getMonth() == month) {
						
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
