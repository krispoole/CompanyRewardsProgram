package com.company.rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.service.RewardsService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RewardsApplicationTests {

	@Autowired
	RewardsService rewardsService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testCalculateTotalRewards() {
		int result = rewardsService.calculateTotalRewards("email1@email.com");
		
		assertEquals(2568, result);
		
	}

}
