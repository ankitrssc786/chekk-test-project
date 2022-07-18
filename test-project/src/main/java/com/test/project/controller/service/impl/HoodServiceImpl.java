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
		while (n > 0 || sum > 1) {
			if (n >= 10) {
				n = n - 10;
				sum = n;
				newHoodFillers.add(10);
			} else if (n >= 9) {
				n = n - 9;
				sum = n;
				newHoodFillers.add(9);
			}  else if (n >= 8) {
				n = n - 8;
				sum = n;
				newHoodFillers.add(8);
			}  else if (n >= 7) {
				n = n - 7;
				sum = n;
				newHoodFillers.add(7);
			}  else if (n >= 6) {
				n = n - 6;
				sum = n;
				newHoodFillers.add(6);
			}  else if (n >= 5) {
				n = n - 5;
				sum = n;
				newHoodFillers.add(5);
			}  else if (n >= 4) {
				n = n - 4;
				sum = n;
				newHoodFillers.add(4);
			}  else if (n >= 3) {
				n = n - 3;
				sum = n;
				newHoodFillers.add(3);
			} else if (n >= 2) {
				n = n - 2;
				sum = n;
				newHoodFillers.add(2);
			} else if (n >= 1) {
				n = n - 1;
				sum = n;
				newHoodFillers.add(1);
			}
		}
		return newHoodFillers;
	}
}
