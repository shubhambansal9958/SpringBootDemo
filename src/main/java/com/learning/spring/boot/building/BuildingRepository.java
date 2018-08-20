package com.learning.spring.boot.building;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import java.lang.String;
import com.learning.spring.boot.building.Building;
import java.util.List;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "building")
public interface BuildingRepository extends CouchbaseRepository<Building, String> {
	
	@Query("#{#n1ql.selectEntity} where #{#n1ql.filter} and companyId = $1 within #{#n1ql.bucket}")
	List<Building> findByCompanyId(String companyId);
}
