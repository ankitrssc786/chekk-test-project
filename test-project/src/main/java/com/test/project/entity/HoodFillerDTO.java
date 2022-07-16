package com.test.project.entity;

import java.util.List;

public class HoodFillerDTO {

	private int hood_capacity;
	private List<Integer> present_weights;

	public int getHood_capacity() {
		return hood_capacity;
	}

	public void setHood_capacity(int hood_capacity) {
		this.hood_capacity = hood_capacity;
	}

	public List<Integer> getPresent_weights() {
		return present_weights;
	}

	public void setPresent_weights(List<Integer> present_weights) {
		this.present_weights = present_weights;
	}

}
