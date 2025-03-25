# Overview
The project is about solving the task given about finding all routes from an origin to a destination with a given static file (`flight.txt`) which consists of all possible flights. It's taking into account pricing and an optional maximum number of flights.

## Features
  - *Graph-based DFS Route-Finding*
  - *Cycle Prevention*
  - *Optional MaxFlights Constraint*
  - *REST API for Route Search*

## Design and Architecture
### Domain
- **Flight:**
  - Encapsulates flight data including origin, destination, and price.

- **Route:**
  - Encapsulates a route as a list of `Flight` objects.
  - Methods such as `getCities()` and `getPrice()` compute the route's cities (derived from the flights) and total cost, respectively.

### **Repository**
- FlightRepository (Interface):
  - `getAllFlights()`: Returns all possible flights.
  - `getFlightsFrom(String origin)`: Returns all flights originating from a given airport.

- FlightRepositoryImpl:
  - Implements the methods above.
  - On instantiation, it loads flight data from `flights.txt` (located in `src/main/resources`) into a list of `Flight` objects, initializing the data when the application starts.

### Service
  - RouteFinderService (Interface):
    - Declares the core method to find all routes.

  - RouteFinderServiceImpl:
    - On creation, builds a `FlightNetwork` (a graph constructed from the list of flights, provided by dependency injection).\
    - Implements the route-finding algorithm using DFS (with cycle prevention and maxFlights constraint).

### Controller
- RouteController:
  - Exposes a REST API endpoint for route search.
  - Uses a request DTO (`RouteRequestDTO`) to validate input (leveraging Spring Boot's validation annotations) and a response DTO (`RouteResponseDTO`) aligned with the task requirements.

## Setup and Installation
- Java Version: Java 21
- Build Tool: Gradle
- Spring Boot Dependencies:
  - `org.springframework.boot:spring-boot-starter-web`
  - `org.springframework.boot:spring-boot-starter-validation`

### To run the project:
  1. Clone the repository.
  2. Build the project using Gradle.
  3. Edit `flights.txt` to your preferences (optional)
  4. Run the Spring Boot application.
## Usage
The only REST API request is at **POST /routes**
**Example Request Body:**
```
{
  "origin": "SOF",
  "destination": "STN",
  "maxFlights": null
}
```
**Example Response:**
```
[
  {
    "cities": ["SOF", "STN", "MLE"],
    "price": 50
  }
]
```

## Application properties
A minimal configuration is provided in `application.properties`.
