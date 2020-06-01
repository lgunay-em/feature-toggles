# Getting Started

Here we have got a Spring Boot web application featuring Feature Toggles.

### Technologies Involved

- Spring Boot as RESTful Backend Web Framework
- Gradle as build tool. (Requires 6.3 or later.)
- JUnit for unit testing
- Mockito for mocking in tests

### Runnin on local

```
~$ gradle bootRun
```

- The application will be running on http://localhost:8080
- Please remember building frontend application before running backend app.

### Testing

### Runnin on local

```
~$ gradle test
```

### Endpoints
```
GET  http://localhost/api/v1/features
POST http://localhost/api/v1/features
PUT  http://localhost/api/v1/features/{featureId}
DELETE http://localhost/api/v1/features/{featureId}

// to assign features to customers
POST http://localhost/api/v1/features/assign
Example request body;
{
	"customerId": "1234",
	"features": [
	    {"name": "aaa"},
	    {"name": "bbb"}
	]
}

// to get features by customer
GET http://localhost/api/v1/features/byCustomer/{customerId}
Example response body
{
    "features": [
        {
            "name": "aaa",
            "active": true,
            "inverted": false,
            "expired": false
        },
        {
            "name": "bbb",
            "active": true,
            "inverted": false,
            "expired": false
        }
    ]
}
```

