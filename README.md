# Cloud Vendor Management System

## Description

### Overview
This Spring Boot application serves as a Cloud Vendor Management System, providing a robust API for performing CRUD operations (Create, Read, Update, Delete) on cloud vendor entities. The system is designed to handle the management of cloud vendor information, offering functionalities to retrieve specific vendor details, retrieve all vendor details, create new vendor entries, update existing vendor details, and delete vendor details.

### Functionality
#### Retrieving Cloud Vendor Details
- Users can retrieve details of a specific cloud vendor by providing the vendor ID. The details include the vendor's name, address, and phone number.

#### Retrieving All Cloud Vendors
- Users can retrieve a comprehensive list of all registered cloud vendors stored in the system.

#### Creating a Cloud Vendor
- Users can create a new cloud vendor by providing necessary information such as vendor ID, name, address, and phone number. Once created, the new vendor is stored in the system.

#### Updating a Cloud Vendor
- Users can update the details of an existing cloud vendor by providing updated information. The system will modify the vendor's details accordingly.

#### Deleting a Cloud Vendor
- Users can delete a cloud vendor from the system by specifying the vendor ID. Once deleted, the vendor's information will no longer be available.

## Task: Unit Testing of Cloud Vendor Back-end Application

### Description
The task involves performing unit testing for the Cloud Vendor Management System using JUnit 5, AssertJ, and Mockito. The primary goal is to ensure that each component (controller, repository, and service) functions correctly and meets the expected behavior.

### CloudVendorControllerTest
- Verifies that the controller correctly handles requests to retrieve specific vendor details, retrieve all vendor details, create new vendor entries, update existing vendor details, and delete vendor details.

### CloudVendorRepositoryTest
- Verifies that the repository correctly interacts with the database to retrieve vendor details by vendor name and handles cases where vendor details are found and not found.

### CloudVendorServiceImplTest
- Verifies that the service implementation accurately creates cloud vendors, updates cloud vendor details, deletes cloud vendors, retrieves cloud vendors by vendor ID, and retrieves all cloud vendors.

### Unit Test Scenarios
- Unit tests cover different scenarios, including successful operations and edge cases, to ensure the system functions as expected and maintains its integrity throughout the vendor management processes.

## Getting Started
1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd <project-directory>`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## Contributors
- Shivam Goyal
