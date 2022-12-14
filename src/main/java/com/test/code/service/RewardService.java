package com.test.code.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.test.code.modal.CustomerReward;
import com.test.code.modal.Reward;

@Service
public class RewardService {

	Map<String, CustomerReward> customerRewards = new HashMap<>();

	public List<CustomerReward> rewardCalculator(Reward rewards) {
        List<CustomerReward> result = new ArrayList<>();
		String custName = rewards.getCustomerName();
		int saleAmount = rewards.getAmount();
		int reward = getRewards(saleAmount);
		int month = Integer.parseInt(rewards.getDate().split("-")[1]);
		if (customerRewards.containsKey(custName)) {
			customerRewards.get(custName).addReward(month, reward);
		} else {
			CustomerReward c = new CustomerReward(custName);
			c.addReward(month, reward);
			customerRewards.put(custName, c);
		}
		for (Map.Entry<String, CustomerReward> c : customerRewards.entrySet()) {
			result.add(c.getValue());
		}
		
		return result;

	}
	
	
	public CustomerReward getCustomerRewardByName(String customerName){
		return customerRewards.get(customerName);
	}

	public static int getRewards(int txnAmount) {
		if (txnAmount <= 50) {
			return 0;
		}
		if (txnAmount <= 100) {
			return txnAmount - 50;
		}
		return (txnAmount - 100) * 2 + 50;
	}

}
