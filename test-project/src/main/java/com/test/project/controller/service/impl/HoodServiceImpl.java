package com.test.project.controller.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.project.controller.service.HoodService;
import com.test.project.entity.HoodFillerDTO;

@Service
public class HoodServiceImpl implements HoodService {

	@Override
	public HoodFillerDTO hoodFillerService(HoodFillerDTO hoodFiller) {

		HoodFillerDTO actualWeight = new HoodFillerDTO();
		List<Integer> newHoodFiller = new ArrayList<>();

		for (int i = 0; i < hoodFiller.getPresent_weights().size(); i++) {
			if (hoodFiller.getPresent_weights().get(i) < hoodFiller.getHood_capacity()) {
				newHoodFiller.add(hoodFiller.getPresent_weights().get(i));
			}
		}

		Collections.sort(newHoodFiller, Collections.reverseOrder());

		int sumofWeigh = 0;
		int totalWeigh = 0;
		List<Integer> maniHoodFiller = new ArrayList<>();
		for (Integer weigh : newHoodFiller) {
			while (hoodFiller.getHood_capacity() > 0) {

				sumofWeigh = addListofArray(maniHoodFiller);
				if (hoodFiller.getHood_capacity() > sumofWeigh) {
					int newSum = addListofArray(maniHoodFiller) + weigh;
					totalWeigh = newSum;
					if (hoodFiller.getHood_capacity() >= newSum) {
						maniHoodFiller.add(weigh);
					} else {
						break;
					}
				} else if (hoodFiller.getHood_capacity() <= sumofWeigh) {
					break;
				}
			}
		}

		if (totalWeigh == hoodFiller.getHood_capacity()) {
			actualWeight.setHood_capacity(hoodFiller.getHood_capacity());
			actualWeight.setPresent_weights(maniHoodFiller);
		} else if (totalWeigh != hoodFiller.getHood_capacity()) {
			List<Integer> maniHoodFillers = new ArrayList<>();

			for (int i = 0; i < hoodFiller.getPresent_weights().size(); i++) {
				if (hoodFiller.getPresent_weights().get(i) < hoodFiller.getHood_capacity()) {
					maniHoodFillers.add(hoodFiller.getPresent_weights().get(i));
				}
			}

			Collections.sort(newHoodFiller, Collections.reverseOrder());

			int sumofWeighs = 0;
			int totalWeighs = 0;
			for (Integer weigh : newHoodFiller) {
				while (hoodFiller.getHood_capacity() > 0) {

					sumofWeighs = addListofArray(maniHoodFillers);
					if (hoodFiller.getHood_capacity() > sumofWeighs) {
						int newSum = addListofArray(maniHoodFillers) + weigh;
						totalWeighs = newSum;
						if (hoodFiller.getHood_capacity() >= newSum) {
							maniHoodFillers.add(weigh);
						} else {
							break;
						}
					} else if (hoodFiller.getHood_capacity() <= sumofWeighs) {
						break;
					}
				}
			}
			if (totalWeighs == hoodFiller.getHood_capacity()) {
				actualWeight.setHood_capacity(hoodFiller.getHood_capacity());
				actualWeight.setPresent_weights(maniHoodFillers);
			} else {
				actualWeight.setHood_capacity(0);
				actualWeight.setPresent_weights(null);
			}
		} else {
			actualWeight.setHood_capacity(0);
			actualWeight.setPresent_weights(null);
		}
		return actualWeight;
	}

	static int addListofArray(List<Integer> newHoodFiller) {
		int sum = 0;
		for (int i = 0; i < newHoodFiller.size(); i++) {
			sum += newHoodFiller.get(i);
		}
		return sum;
	}
}
