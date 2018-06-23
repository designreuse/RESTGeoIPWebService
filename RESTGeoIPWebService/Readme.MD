RESTGeoIPWebService instruction
==================================

Technologies for back-end: 
	Spring (Boot, Data), Hibernate/JPA, REST API;
Database: 
	MySQL;

Needed: MySQL locally installed, downloaded and unzipped csv file (for importing data).
It can be downloaded here: https://drive.google.com/file/d/1IXj2aYLic0hpcUR8UfLnpKScpjy_ZNb_/view?usp=sharing
or here: https://lite.ip2location.com/ – DB5.LITE.

Also before running application it's needed to modify:
 - project script (data.sql) and replace the row 'LOAD DATA LOCAL INFILE' with your downloaded csv's path;
 - in application.properties replace 'username' and 'password' with correct values.


Usage: open in browser 'http://localhost:9090/geoip/{your_typed_ip} and type ip-address instead 'your_typed_ip'.
Example: http://localhost:9090/geoip/8.8.8.8

You'll get response like that:

	{
	  "canonicalIPv4Representation": "8.8.8.8",
	  "cityName": "Mountain View",
	  "countryCode": "US",
	  "countryName": "United States",
	  "IPv4": "134744072",
	  "latitude": "37.405992",
	  "longitude": "-122.078515",
	  "regionName": "California"
	}


