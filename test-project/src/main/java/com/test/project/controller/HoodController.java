package com.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.controller.service.HoodService;
import com.test.project.entity.HoodFillerDTO;
import com.test.project.entity.HoodFillerResponse;

@RestController
public class HoodController {

	@Autowired
	HoodService hoodService;

	@RequestMapping("/")
	public String index() {
		return "Hello Chekk Manager, I am Ankit\n";
	}

	@RequestMapping(value = "/hoodfiller", method = RequestMethod.POST)
	@ResponseBody
	public HoodFillerResponse addHoodFiller(@RequestBody HoodFillerDTO hoodFiller) {

		HoodFillerResponse rsp = new HoodFillerResponse();
		try {
			if (hoodFiller == null || hoodFiller.getHood_capacity() == 0
					|| hoodFiller.getPresent_weights().size() == 0) {
				rsp.setMsg("Hood capacity or Present weights cannot be empty or capacity zero. ");
				rsp.setHoodFillerDto(null);
			} else {

				HoodFillerDTO hoodRsp = hoodService.hoodFillerService(hoodFiller);
				if (hoodRsp.getHood_capacity() == 0) {
					rsp.setMsg(
							" Error: Cannot Manipulated as input number is not correct (Hood capacity cannot be equal to present manipulated weights.");
					rsp.setHoodFillerDto(null);
				} else {
					rsp.setMsg("Successfully Manipulated");
					rsp.setHoodFillerDto(hoodRsp);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return rsp;
	}

}
