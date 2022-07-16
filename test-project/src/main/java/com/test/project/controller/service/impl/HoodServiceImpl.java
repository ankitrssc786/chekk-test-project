package com.test.project.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.project.controller.service.HoodService;
import com.test.project.entity.HoodFillerDTO;

@Service
public class HoodServiceImpl implements HoodService {

	@Override
	public HoodFillerDTO hoodFillerService(HoodFillerDTO hoodFiller) {

		HoodFillerDTO actualWeight = new HoodFillerDTO();
		
		int weightCount = 0;
		List<Integer> newHoodFiller = new ArrayList<>();

		for (Integer weigh : hoodFiller.getPresent_weights()) {
			if (weigh <= 10 || weigh <= 5 || weigh <= 2) {
				weightCount = weightCount + weigh;
				newHoodFiller.add(weigh);
			}
		}
		Integer restHoodFiller = hoodFiller.getHood_capacity() - weightCount;
		newHoodFiller = digSum(restHoodFiller, newHoodFiller);

		actualWeight.setHood_capacity(hoodFiller.getHood_capacity());
		actualWeight.setPresent_weights(newHoodFiller);
		
		return actualWeight;
	}

	static List<Integer> digSum(int n, List<Integer> newHoodFillers) {
		int sum = 0;
		while (n > 0 || sum > 2) {
			if (n >= 10) {
				n = n - 10;
				sum = n;
				newHoodFillers.add(10);
			} else if (n >= 5) {
				n = n - 5;
				sum = n;
				newHoodFillers.add(5);
			} else if (n >= 2) {
				n = n - 2;
				sum = n;
				newHoodFillers.add(2);
			}
		}
		return newHoodFillers;
	}
}
