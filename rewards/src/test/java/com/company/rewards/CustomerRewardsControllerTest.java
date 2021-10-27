package com.company.rewards;

import static org.assertj.core.api.Assertions.*;
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
		when(rewardsService.calculateTotalRewards(ArgumentMatchers.anyString())).thenReturn(25);
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		ResponseEntity<Integer> responseEntity = customerRewardsController.retrieveTotalRewards("email1@email.com");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
//		assertThat(((Rewards)responseEntity.getBody()).getTotalRewards()).isEqualTo(200);
	}

}
