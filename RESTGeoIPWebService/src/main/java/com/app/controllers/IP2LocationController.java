package com.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.app.Utils.ipToLong;
import com.app.entities.IP2Location;
import com.app.repositories.IP2LocationRepository;

@RestController
@Transactional
@RequestMapping(value = "/geoip")
public class IP2LocationController {
	
	private static final Logger logger = LoggerFactory.getLogger(IP2LocationController.class);
	
	@Autowired
	private IP2LocationRepository ipLocationRepository;

	@GetMapping(value = "/{ip}", headers = "Accept=application/json")
	public ResponseEntity<IP2Location> getIPLocationByIP(@PathVariable("ip") String ip) {
		logger.info("In getIPLocationByIP()");
		Long longIp = ipToLong(ip);
		IP2Location ipLocation = ipLocationRepository.findByIp(longIp);
		if (ipLocation == null) {
			logger.info("Location with IP=" + ip + "wasn't found");
			return new ResponseEntity<IP2Location>(ipLocation, HttpStatus.NOT_FOUND);
		}
		ipLocation.setCanonicalIPv4Representation(ip);
		ipLocation.setIPv4(longIp.toString());
		logger.info("Location with 	ID=" + ip + " was found: " + ipLocation);
		logger.info("Out of getIPLocationByIP()");
		return new ResponseEntity<IP2Location>(ipLocation, HttpStatus.OK);
	}

}
