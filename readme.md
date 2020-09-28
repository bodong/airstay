# AirStay
Rest API for Hotel booking

## How to run the application
1. Install mongodb on your machine, google it how to do
2. Checkout the code
3. Go to airstay (root directory) and perform ``mvn clean install``. It will execute all test classes as well. If you want to skip it, just run as : ``mvn clean install -D skipTests=true``
4. Run spring boot via command line : ``mvn spring:boot run -Ddata=true``. VM argument ``-Ddata=true`` is required to setup pre-populated data in the development environment.
5. Run spring boot via intellij/eclipse : run the HotelExplorerApplication.java with vm argument ``-Ddata=true``

## How to read the rest api documentation
Once the application run in your local, you should be able to see what are APIs available. Go to : http://localhost:8080/swagger-ui.html


## Assumption on this app ##
### Technically ###
1. There is no auth implemented to call REST Api
2. No split module at the moment with limited time, but this app can be scaled, just need to create another sub-module for new functionalities that required to have dedicated module.
3. There is no spring security implemented. 
4. There is no encryption for database connection implemented. 

### Functionally ###
1. No login user implemented. But user data is populated. If given user to make booking is not valid, it will be denied the request. 
2. Data provided is just mock data.
3. In this system, the assumption is user make booking per hotel per room, currently is not supported for multiple hotel and multiple room in one booking. 
 

