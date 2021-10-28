package com.company.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.entity.Rewards;
import com.company.service.RewardsService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RewardsServiceTest {
	
	@Autowired
	RewardsService rewardsService;
	
	@Test
	public void testCalculateTotalRewards() {
		Rewards result = rewardsService.calculateTotalRewards("email1@email.com");
		
		assertEquals(2568, result.getCustomerRewards());
		assertEquals("email1@email.com", result.getCustomerEmail());
		
	}
	
	@Test
	public void testCalculateRewardsForMonth() {
		Rewards result = rewardsService.calculateRewardsForMonth("email1@email.com", 10);
		
		assertEquals(2113, result.getCustomerRewards());
		assertEquals("email1@email.com", result.getCustomerEmail());
		
	}

}
