package com.learning.spring.boot.building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService{

	@Autowired
	BuildingRepository buildingResository;
	
	public Building save(Building building) {		
		return buildingResository.save(building);
	}

}
