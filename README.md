# ccvalidator_service
A simple credit card validator service
Assumptions taken into account- 

The webservice is invoked from a UI application which follows the contract provided by the service. 
Only VISA or MASTERCARD will be validated and rest will be flagged as UNKOWN by the webservice.
The blacklist.json file is part of the resources in the project. That is limitation cause every time the list is updated the whole web service will be packaged again to include the updated blacklist.json. Because of time constraint on the assignment, I didn’t implemented the file to be picked from a remote location instead of project resource and stored in Cache for easy and fast retrieval. 
The expiry Date format will be only MM/YY. In any other case or format of the expiry date the card status during validation will result as false.
Assuming that there is not strict firewall restrictions in using the gradle libraries. 
I am using JAVA 10, Spring-boot 2.1.3.RELEASE version. 


	Testing- 
	
	I have setup webserivce so it can be tested with Swagger UI or it can also be tested using POSTMAN for both the http methods in the service. 
	Steps to test- 
Import the project as GRADLE in Intellij. 
It will also import the runConfig to run the web services locally. It the import doesn’t produces the run config. Directly run the CCValidatorApplication from the Intllij and it will create one run config. 
The console will show that the web service has started successfully. 
You will find <DOWNLOAD_LOCATION>/ccvalidator_service/src/main/java/com/expedia/validator/dist/index.html#/ . Open this page using chrome and you will see the validatorService running on localhost:8080. (Make sure that port 8080 is not being currently used in your system or the application start will fail.)



Check the Model defined to set the values to test the methods.
If you problem running the webserivce you can also test the unit test method that have been added. 

References- 

	Some references have been used while implementing the solution - 
Luhn Algorithm - https://www.geeksforgeeks.org/luhn-algorithm/
Regular Expression for MasterCard and Visa - https://www.regular-expressions.info/creditcard.html
Swagger - https://swagger.io/
Swagger UI- https://github.com/swagger-api/swagger-ui (I have used the dist folder and set it up in the project so that it can be used for fast testing the web service)
I have used https://start.spring.io/ to initialize a spring project.
