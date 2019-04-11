# Getting Started

### Guides
start the spring boot server using any IDE

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