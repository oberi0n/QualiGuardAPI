# Backend of KPI Monitoring Application

This repository contains the backend of a KPI monitoring application designed for managing and tracking supplier and subcontractor performance. The backend is built using **Java Quarkus**.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)


## Overview

The backend of this application serves as the core for managing and processing KPI data. It offers secure API endpoints for the frontend and ensures efficient communication with the MySQL database. Key features include data management, validation, and role-based access control.

## Features

- **API Endpoints:** Secure endpoints for CRUD operations on KPIs, suppliers, and subcontractors.
- **Role-Based Access Control:** Authentication and authorization for different user roles.
- **Data Validation:** Ensures data integrity for all operations.
- **Performance Optimizations:** Designed for high performance with minimal latency.

## Technologies Used

- **Java Quarkus**: A lightweight Java framework optimized for Kubernetes and cloud-native applications.
- **MySQL**: Relational database for data storage.
- **Hibernate ORM with Panache**: Simplified ORM for database interactions.
- **RESTEasy**: To build RESTful APIs.
- **Jandex**: For faster deployment and reflection.
- **Docker**: Containerized deployment.

