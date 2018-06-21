package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.IP2Location;

@Repository
public interface IP2LocationRepository extends JpaRepository<IP2Location, Long>{

	@Query("select loc from IP2Location loc where loc.ipFrom <= :ip and loc.ipTo >= :ip")
	public IP2Location findByIp(@Param("ip") Long ip);

}
