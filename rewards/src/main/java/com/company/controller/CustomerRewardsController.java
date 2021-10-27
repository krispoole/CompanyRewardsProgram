package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Customer;
import com.company.entity.Transaction;
import com.company.repository.CustomerRepository;
import com.company.repository.TransactionRepository;
import com.company.service.RewardsService;

@CrossOrigin
@RestController
public class CustomerRewardsController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	RewardsService rewardService;
	
	@RequestMapping(value = "/retrieve-customer-rewards-total", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private ResponseEntity<Integer> retrieveTotalRewards(String email){
		
		Customer customer = customerRepository.findCustomerId(email);
		List<Transaction> allTransactions = transactionRepository.returnAllTransactionsForCustomer(customer.getCustomerId());
		
		Integer total = rewardService.calculateTotalRewards(allTransactions);
		
		return new ResponseEntity<>(total, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retrieve-customer-rewards-by-month", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private ResponseEntity<Integer> retrieveRewardsByMonth(String email, Integer month){
		
		Customer customer = customerRepository.findCustomerId(email);
		List<Transaction> allTransactions = transactionRepository.returnAllTransactionsForCustomer(customer.getCustomerId());
		
		Integer total = rewardService.calculateRewardsForMonth(allTransactions, month);
		
		return new ResponseEntity<>(total, HttpStatus.OK);
	}
	
}
