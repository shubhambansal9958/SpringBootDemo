package com.learning.spring.boot.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {

	@Autowired
	BuildingService buildingService;
	
	@RequestMapping(method=RequestMethod.POST , value="/building")
	public void save(@RequestBody Building building) {
		buildingService.save(building);
	}
}
