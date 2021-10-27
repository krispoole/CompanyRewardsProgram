package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.RewardsService;

@CrossOrigin
@RestController
public class CustomerRewardsController {

	@Autowired
	RewardsService rewardService;
	
	@RequestMapping(value = "/retrieve-customer-rewards-total", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Integer> retrieveTotalRewards(String email){
		
		Integer total = rewardService.calculateTotalRewards(email);
		
		return new ResponseEntity<>(total, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retrieve-customer-rewards-by-month", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Integer> retrieveRewardsByMonth(String email, String month){
		
		Integer total = rewardService.calculateRewardsForMonth(email, month);
		
		return new ResponseEntity<>(total, HttpStatus.OK);
	}
	
}
