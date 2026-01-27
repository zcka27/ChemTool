# ChemTool

**ChemTool** is a RESTful API designed to provide common thermodynamic utilities for Chemical Engineers. 
The main objective of this repository is to build functional software while mastering the fundamentals of **Java Spring Boot**, **PostgreSQL**, and modern **Software Architecture**.

## Project Objective

This project serves as part of my **learning portfolio**, main objective is making things simple and at the same time make a functional tool for Chemical Engineers.
It currently focuses on thermodynamic properties, specifically calculating Vapor Pressure using the **Antoine Equation**.

> **Note:** As this is a learning project, the source code contains comments intended as personal study notes to reinforce concepts, rather than following standard documentation practices.

## Implemented Featrures 

### Backend (Spring Boot Core)

- **REST API** for thermodynamic calculations
- **Antoine Equation** for vapor pressure calculations
- **Relational database** with JPA/Hibernate
- **Custom exception handling**
- **Data validation** and temperature range checking
- **Automatic migrations** with Flyway

##  Project Structure

The project follows a Layered Architecture pattern to ensure separation of concerns and maintainability.
```
src/main/java/com/chemicaltools/chemicaltools
├── controller
│   └── AntoineController.java
├── exception
│   ├── SubstanceNotFoundException.java
│   └── TemperatureOutRangeException.java
├── model
│   ├── AntoineProperties.java
│   └── Substance.java
├── repository
│   └── SubstanceRepository.java
├── service
│   └── AntoineService.java
└── ChemicalToolsApplication.java
```

 ## Tech Stack
 ### Backend
 - Java 17
 - Spring Boot 3
 - Maven
 - PostgreSQL + Flyway (Migration)

## Roadmap
  Project will evolve towards a full Cloud-Native architecture:

- [ ] **Frontend:** Modern web interface using **TypeScript** & **Node.js**.
- [ ] **Infrastructure:** Containerization of the PostgreSQL database using **Docker**.
- [ ] **Cloud:** Deployment and CI/CD integration with **AWS** (EC2/RDS).
- [ ] **Features:** Add more Chemical Properties to be shown. Calculate bubble point temperature instead of bubble point pressure.
