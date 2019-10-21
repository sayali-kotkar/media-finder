# Media Finder
  
Media finder system allows the user to fetch list of albums and books from Itune store and google store respectively  by name.

#How to use this api ?
  1. Hit below url to get the result for your search criteria against apple itune and google books api.
       http://localhost:8888/media?searchString={input term}
  2. This api will by default return maximum of 5 books and maximum of 5 albums related to input term.     
  3. API can be configured to return more number of records by passing limit parameter in url.
  		http://localhost:8888/media?searchString={input term}&limit={limit}
  	 where limit is no of records expected in response for each mediaType. e.g if limit parameter is 10, response will contain 10 records for books and 10 record for album.
  
# Technology Stack:
  * Java 1.8
  * Spring Boot, Spring Actuator
  * Swagger UI

# Prerequisites:
  * Install Java 8
  * Install Maven build tool

# How to setup this application locally ?
  1. Clone the repository from command line using below command
      git clone https://github.com/sayali-kotkar/media-finder.git).
  2. Run mvn spring-boot:run command from the project folder using command prompt/terminal.
  
# Swagger UI Url:
  * http://localhost:8888/media/swagger-ui.html
  
# Application Metrics

Basic application metrix can be  accessed using Actuator URLs

http://localhost:8080/health

http://localhost:8080/info

http://localhost:8080/metrics

http://localhost:8080/trace

Spring Boot Actuator provides dependency management and auto-configuration for Micrometer, an application metrics facade that supports numerous monitoring systems, including:

.AppOptics
.Atlas
.Datadog
.Dynatrace
.Elastic
.JMX 
