# HMCTS Task Management – Spring Boot Backend

This is the backend API for the HMCTS Task Management system.  
Built using Spring Boot

## Features
- Full CRUD REST API for Task management  
- PostgreSQL database integration  
- Service and repository layers  
- JPA entity modelling  
- CORS enabled for Angular frontend  


## Project Structure
src/main/java/com.technicaltest.hmcts
 ─ controller      → API endpoints
 ─ service         → Interfaces
 ─ serviceImpl     → Implementations
 ─ repository      → Spring Data JPA repositories
 ─ entity          → Task entity model

## Configure Connection in `application.properties`

## REST API Endpoints
| Method | Endpoint | Description |

| GET | `/tasks` | Get all tasks |
| POST | `/tasks` | Create task |
| PUT | `/tasks/{id}` | Update task |
| DELETE | `/tasks/{id}` | Delete task |

## Tests
Includes:
- Service layer unit tests with Mockito  
- CRUD logic validation  

## Requirements
- Java 17+
- Maven 3+
- PostgreSQL running locally

