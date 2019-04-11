# Technologies used:

 1. Build: Maven
 2. Web Services Framework: Spring Boot
 3. MongoDB Interface: MongoDB Repository
 4. Unit Test: JUnit Requirements: Java 8, Maven, MongoDB

# REST api's

## Assumptions
 1. Every client has "_id", "name", "desc" and investor[] (array of investors)
 2. Every invsetor has "_id", "name", "desc" and funds[] (array of funds)
 3. Every fund has "_id", "name" and "fund value"
 
### API's
 1. http://localhost:8080/clients - lists all the clients
 2. http://localhost:8080/clients/{id} - Returns the list of investors in client
 3. http://localhost:8080/investors/2 - Returns the list of fund for investor
 4. http://localhost:8080/clients/   (POST method) - Creates a client, you have to provide an id(overrides the _id in mongo to simplify the application)
 	#### Sample req:
 			{
			    "_id": "11",
			    "name": "asC",
			    "description": "asdads",
			    "investors": [2,1,5,3]
			}
 5.  http://localhost:8080/clients/4 (PUT method) - Edits a client
 
 ### Start the application
  1. Import the project in an IDE and run the application as springBoot App
  2. Access the above mentioned API's from postman app or using curl

 ### Mongo DB set up
  1. Create a db called 'invest'
  2. Run below insert commands to load sample data
  	#### inser script:
	
                        db.clients.insertMany([{ "_id" : "1", "name" : "Cli 1", "description" : "cli 1", "investors" : [ 1, 2, 3 ]},
			{ "_id" : "2", "name" : "Cli 2", "description" : "cli 2", "investors" : [ 3, 2, 4 ]},
			{ "_id" : "3", "name" : "Cli 2", "description" : "1", "investors" : [ 2 ]},
			{ "_id" : "31", "name" : "22", "description" : "22", "investors" : [ 4, 5 ]},
			{ "_id" : "4", "name" : "C-4", "description" : "4", "investors" : [ 2 ]}])

			db.funds.insertMany([{"_id" : "22", "name" : "F2", "value":23},
			 {"_id" : "11", "name" : "F1", "value":12},
			 {"_id" : "33", "name" : "F3", "value":66},
			 {"_id" : "44", "name" : "F4", "value":47},
			 {"_id" : "55", "name" : "F5", "value":99}])
 
		 	db.investors.insertMany([{ "_id" : "1", "name" : "F1", "description" : "F1", "funds" : [ 33, 22 ] },
			{ "_id" : "2", "name" : "F2", "description" : "F2", "funds" : [ 33, 11 ] },
			{ "_id" : "3", "name" : "F3", "description" : "F3", "funds" : [ 22, 11 ] },
			{ "_id" : "5", "name" : "F5", "description" : "F5", "funds" : [ 55, 44 ] }])

# UIClient

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.8.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.
