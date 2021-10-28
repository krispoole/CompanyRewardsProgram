package com.company.rewards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.company.controller.CustomerRewardsController;
import com.company.entity.Rewards;
import com.company.service.RewardsService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRewardsControllerTest {
	
	@Autowired
	private CustomerRewardsController customerRewardsController;
	
	@MockBean
	private RewardsService rewardsService;
	
	@Test
	public void testRetrieveTotalRewards() {
		Rewards rewards = new Rewards();
		rewards.setCustomerEmail("email1@email.com");
		rewards.setCustomerRewards(2568);
		
		when(rewardsService.calculateTotalRewards(ArgumentMatchers.anyString())).thenReturn(rewards);
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		ResponseEntity<Rewards> responseEntity = customerRewardsController.retrieveTotalRewards("email1@email.com");
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(((Rewards)responseEntity.getBody()).getCustomerEmail().equals("email1@email.com"));
		assertThat(((Rewards)responseEntity.getBody()).getCustomerRewards().equals(2568));
	}
	
	@Test
	public void testRetrieveRewardsByMonth() {
		Rewards rewards = new Rewards();
		rewards.setCustomerEmail("email1@email.com");
		rewards.setCustomerRewards(2568);
		
		when(rewardsService.calculateRewardsForMonth(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(rewards);
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		ResponseEntity<Rewards> responseEntity = customerRewardsController.retrieveRewardsByMonth("email1@email.com", 9);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(((Rewards)responseEntity.getBody()).getCustomerEmail().equals("email1@email.com"));
		assertThat(((Rewards)responseEntity.getBody()).getCustomerRewards().equals(450));
	}

}
