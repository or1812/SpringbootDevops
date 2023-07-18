Springboot Devops Project

## Overview
This is a Spring Boot web application that provides an API for logging activities. It allows users to create custom log entries and retrieve a list of all log entries. The application uses a H2 database (MySQL) to store log entries.

## Prerequisites
Before running this application, ensure that you have the following installed:

- Amazon Corretto 20
- Python Interpreter

## Installation

**Clone the repository to your local machine:**
```
git clone https://github.com/or1812/SpringbootDevops.git
```

You can build with Maven and run the spring boot web application using IntelliJ IDEA.
If you want an alternative way then:

**Navigate to the project directory:**
```
cd ./SpringbootDevops/webapp
```

**Build the application using Maven:**
```
mvn clean package
```

## Usage
To run the application, use the following command:
```
java -jar target/<Your Artifact>.jar
```

The application will start, and you can access it and view logs through the following URL:
```
http://localhost:8080/logs
```

Transaction route for new log entry to the database:
```
http://localhost:8080/newlog
```

## Testing
After the web application started, you can execute python unit tests in order to check functionality, you can run it directly from PycharmCommunity (or another IDE).


**Navigate to the tests directory**
```
cd webapp/tests
```

**Use the following command to perform unit tests**
```
python3 unit.py
```


