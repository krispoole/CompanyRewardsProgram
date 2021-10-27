package com.company.rewards.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests {

//		The methods below were replicated from the RewardsService class to test the logic

	int[] allTransactions = {75, 55, 120, 150, 1000};
	
		@Test
		public void calculateTotalRewards(int[] allTransactions) {
			int total = 0;
			
			for (int transaction : allTransactions) {
			
				int transactionAmount = transaction;
				
				if (transactionAmount > 50 && transactionAmount < 100) {
					total += transactionAmount - 50;
				}
				
				if (transactionAmount >= 100) {
					total += 50 + (transactionAmount - 100) * 2;
				}
			}
			
			assertEquals(20, total);
			
		}
		
		@Test
		public void calculateRewardsForMonth(int[] allTransactions, int month) {
			
			int total = 0;
			
			for (int transaction : allTransactions) {
							
					int transactionAmount = transaction;
					
					if (transactionAmount > 50 && transactionAmount < 100) {
						total += transactionAmount - 50;
					}
					
					if (transactionAmount >= 100) {
						total += 50 + (transactionAmount - 100) * 2;
					}
				}		
			assertEquals(20, total);
		}

}
