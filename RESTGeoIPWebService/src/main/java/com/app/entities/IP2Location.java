package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ip2location_db5",
indexes = {
	@Index(columnList = "ip_from", name = "idx_ip_from"),
	@Index(columnList = "ip_to", name = "idx_ip_to"),
	@Index(columnList = "ip_from,ip_to", name = "idx_ip_from_to" )
})
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "ipFrom", "ipTo" })
public class IP2Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ip_from", columnDefinition = "INT(10) UNSIGNED")
	private Long ipFrom;

	@Column(name = "ip_to", columnDefinition = "INT(10) UNSIGNED")
	private Long ipTo;

	@Column(name = "country_code", columnDefinition = "CHAR(2) DEFAULT NULL")
	private String countryCode;

	@Column(name = "country_name", length = 64)
	private String countryName;

	@Column(name = "region_name", length = 128)
	private String regionName;

	@Column(name = "city_name", length = 128)
	private String cityName;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;
	
	@Transient
	private String canonicalIPv4Representation;
	
	@Transient
	private String iPv4;

	public IP2Location() {
	}

	public IP2Location(Long ipFrom, Long ipTo, String countryCode, String countryName, String regionName,
			String cityName, Double latitude, Double longitude) {
		this.ipFrom = ipFrom;
		this.ipTo = ipTo;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionName = regionName;
		this.cityName = cityName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getIpFrom() {
		return ipFrom;
	}

	public void setIpFrom(Long ipFrom) {
		this.ipFrom = ipFrom;
	}

	public Long getIpTo() {
		return ipTo;
	}

	public void setIpTo(Long ipTo) {
		this.ipTo = ipTo;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	

	public String getCanonicalIPv4Representation() {
		return canonicalIPv4Representation;
	}

	public void setCanonicalIPv4Representation(String canonicalIPv4Representation) {
		this.canonicalIPv4Representation = canonicalIPv4Representation;
	}

	public String getIPv4() {
		return iPv4;
	}

	public void setIPv4(String iPv4) {
		this.iPv4 = iPv4;
	}

	@Override
	public String toString() {
		return new StringBuilder("IP2Location [")
				.append("countryCode=" + countryCode).append(", ")
				.append("countryName=" + countryName).append(", ")
				.append("regionName=" + regionName).append(", ")
				.append("cityName=" + cityName).append(", ")
				.append("latitude=" + latitude).append(", ")
				.append("longitude=" + longitude).append(", ")
				.append("canonicalIPv4Representation=" + canonicalIPv4Representation).append(", ")
				.append("iPv4=" + iPv4).append("]")
				.toString();
	}

}
