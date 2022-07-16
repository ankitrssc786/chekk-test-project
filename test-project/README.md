 ## Steps to run the application ##

1. Import project from github.

2. Two ways to run the application.
	a. Run as Spring boot application
	b. Install docker and deploy the application.
		b.1 docker-compose up -d :  To start & run the container
		b.2 docker-compose down : To stop the container
3. Install postman or use curl to run API
	a. http://localhost:8080/hoodfiller and method is POST
	
		a.1 Body Request : 
		{
    "hood_capacity": 41,
    "present_weights": [
        2,
        5,
        10,
        50,
        100
     ]
   }
   		a.2 Response : 
   		{
    "hood_capacity": 41,
    "present_weights": [
        2,
        5,
        10,
        10,
        10,
        2,
        2
    ]
}


Request :

{
    "hood_capacity": 61,
    "present_weights": [
        2,
        5,
        10,
        50,
        100
    ]
}

Response :

{
    "hood_capacity": 61,
    "present_weights": [
        2,
        5,
        10,
        10,
        10,
        10,
        10,
        2,
        2
    ]
}

Note:  Attached word document include testing


