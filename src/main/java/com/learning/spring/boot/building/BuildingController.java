package com.learning.spring.boot.building;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {

	@Autowired
	BuildingService buildingService;

	@RequestMapping(method = RequestMethod.POST, value = "/building")
	public void save(@RequestBody Building building) {
		buildingService.save(building);
	}

	@RequestMapping("/building/{id}")
	public Optional<Building> findById(@PathVariable("id") String id) {
		return buildingService.findById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/building/{id}")
	public void deleteById(@PathVariable("id") String id) {
		buildingService.deleteById(id);
	}

	@RequestMapping("/building/companyId/{companyId}")
	public List<Building> findByCompanyId(@PathVariable("companyId") String companyId) {
		return buildingService.findByCompanyId(companyId);
	}


}
