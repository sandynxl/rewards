package com.test.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.code.modal.CustomerReward;
import com.test.code.modal.Reward;
import com.test.code.service.RewardService;

@RestController
public class RewardController {
	
	@Autowired
	private RewardService rewardService;
	
	@GetMapping("/rewards/{customername}")
	public ResponseEntity<CustomerReward> getRewards(@PathVariable String customername){
		
		CustomerReward result = rewardService.getCustomerRewardByName(customername);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	@PostMapping("/rewards")
	public ResponseEntity<List<CustomerReward>> getRewardsByCustomerInfo(@RequestBody Reward reward){
		List<CustomerReward> rewards =rewardService.rewardCalculator(reward);
		return new ResponseEntity<>(rewards,HttpStatus.CREATED);
	}

}
