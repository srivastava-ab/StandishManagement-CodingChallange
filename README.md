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

# UIClient

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.8.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.
