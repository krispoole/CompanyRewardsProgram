package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.data.FakeTransactions;
import com.company.entity.Rewards;
import com.company.entity.Transaction;

@Service
public class RewardsService {
	
	@Autowired
	FakeTransactions fakeTransactions;
	
	public Rewards calculateTotalRewards(String email) {
		
		List<Transaction> allTransactions = fakeTransactions.getTransactions(email);
	
		Rewards rewards = new Rewards();
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
		
		rewards.setCustomerEmail(email);
		rewards.setCustomerRewards(total);
		
		return rewards;
	}
	
	
//	Input value for month is numerical value starting with January = 0;
	
	public Rewards calculateRewardsForMonth(String email, int month) {	

		List<Transaction> allTransactions = fakeTransactions.getTransactions(email);
		
		Rewards rewards = new Rewards();
		Integer total = 0;
		
		for (Transaction transaction : allTransactions) {
			
			if (transaction.getTransactionDate().getMonthValue() == month) {
						
				Integer transactionAmount = transaction.getTransactionAmount().intValue();
				
				if (transactionAmount > 50 && transactionAmount < 100) {
					total += transactionAmount - 50;
				}
				
				if (transactionAmount >= 100) {
					total += 50 + (transactionAmount - 100) * 2;
				}
			}
		}
		
		
		rewards.setCustomerEmail(email);
		rewards.setCustomerRewards(total);
		
		return rewards;
	}

}
