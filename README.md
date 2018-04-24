# and-digital-telecoms-api
And digital coding exercise

This project contains my code for the imaginary API created for a telecoms company.

How to run the application

- Clone the repository
- Make sure Java is setup/installed on your machine
- Run the following command from the root folder:
  java -jar build/libs/and-digital-telecoms-api-0.0.1-SNAPSHOT.jar

There are 3 endpoints which will provide sample data.

API Description:
Get a list of all the phonenumbers

API Endpoint:
GET localhost:8080/api/phonenumbers

API Description:
Get a list of all the phonenumbers for a given customer.
A valid customer id should be passed as a path parameter, otherwise a 404 Not Found error will be returned.

API Endpoint:
GET localhost:8080/api/customers/{id}/phonenumbers
e.g. localhost:8080/api/customers/1/phonenumbers

API Description:
Activate a phonenumber.
A valid phonenumber should be passed as a path parameter, otherwise a 404 Not Found error will be returned.

API Endpoint:
PUT localhost:8080/api/phonenumbers/{phonenumber}
e.g. localhost:8080/api/phonenumbers/07469852364