package com.learning.spring.boot.building;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

	@Autowired
	BuildingRepository buildingResository;

	public Building save(Building building) {
		return buildingResository.save(building);
	}

	public Optional<Building> findById(String id) {
		return buildingResository.findById(id);
	}

	public void deleteById(String id) {
		buildingResository.deleteById(id);
	}

	public List<Building> findByCompanyId(String companyId) {
		return buildingResository.findByCompanyId(companyId);
	}

}
