package com.test.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.controller.service.HoodService;
import com.test.project.entity.HoodFillerDTO;

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
	public HoodFillerDTO addHoodFiller(@RequestBody HoodFillerDTO hoodFiller) {
		return hoodService.hoodFillerService(hoodFiller);
	}

}
