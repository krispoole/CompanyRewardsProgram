package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Rewards;
import com.company.service.RewardsService;

@CrossOrigin
@RestController
public class CustomerRewardsController {

	@Autowired
	RewardsService rewardService;
	
	@RequestMapping(value = "/retrieve-customer-rewards-total", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Rewards> retrieveTotalRewards(String email){
		
		Rewards rewards = rewardService.calculateTotalRewards(email);
		
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}
	
//	Input value for month is numerical value starting with January = 0;
	
	@RequestMapping(value = "/retrieve-customer-rewards-by-month", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Rewards> retrieveRewardsByMonth(String email, int month){
		
		Rewards rewards = rewardService.calculateRewardsForMonth(email, month);
		
		return new ResponseEntity<>(rewards, HttpStatus.OK);
	}
	
}
