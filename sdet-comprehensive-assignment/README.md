# SDET Comprehensive Assignment - Basic Level

This project contains solutions for a comprehensive SDET assignment covering multiple testing concepts and technologies.

## Project Overview

This assignment demonstrates proficiency in:
- Java OOPs concepts
- Python programming
- Selenium WebDriver (Java & Python)
- TestNG framework
- Pytest framework
- API Testing with Postman
- Performance Testing with JMeter
- Maven build tool
- Version Control with Git

## Project Structure

```
sdet-comprehensive-assignment/
├── java-programs/           # Java Maven project
│   ├── src/
│   │   ├── main/java/
│   │   │   └── com/sdet/
│   │   │       ├── oops/          # Problem 1: Java OOPs
│   │   │       └── utils/         # Utility classes
│   │   └── test/java/
│   │       └── com/sdet/tests/    # Problems 3, 4, 5: Selenium + TestNG
│   ├── pom.xml
│   └── testng.xml
├── python-programs/         # Python programs
│   ├── student_school.py    # Problem 2: Python OOPs
│   └── test_w3schools.py    # Problem 9: Pytest + Selenium
├── postman/                 # Problem 7: API Testing
│   └── REST_API_Collection.json
├── jmeter/                  # Problem 8: Performance Testing
│   └── MakeMyTrip_TestPlan.jmx
└── README.md
```

## Problems Addressed

### 1. Java OOPs - Account Management System
- Base class: `Account` with interest calculation
- Derived classes: `SavingsAccount` and `CurrentAccount`
- Demonstrates inheritance and method overriding

### 2. Python OOPs - Student Management System
- Base class: `Student` with Name, Grade, Age
- Derived class: `School` inheriting from Student
- Methods: `display()` and `SchoolStudentDisplay()`

### 3. Selenium WebDriver - Firefox (MakeMyTrip Logo)
- Verifies MakeMyTrip logo presence
- Uses TestNG annotations
- Browser: Firefox

### 4. Selenium WebDriver - Chrome (MakeMyTrip Flights)
- Automates flight search: Flights → OneWay → FROM/TO
- Uses XPath locators
- Uses TestNG annotations
- Browser: Chrome

### 5. TestNG Integration
- All Selenium tests use TestNG @Test annotation
- @BeforeMethod for browser setup
- HTML report generation

### 6. Maven Project
- All Java programs in Maven structure
- Dependencies managed in pom.xml
- Run using Maven commands

### 7. Postman API Testing
- REST API: https://api.restful-api.dev
- CRUD operations: GET, POST, PUT, DELETE
- Positive and negative test cases
- HTTP status code verification

### 8. JMeter Performance Testing
- Thread Group configuration
- Target: https://www.makemytrip.com/
- Assertions for response validation
- Listeners for result analysis

### 9. Python Pytest - W3Schools Logo
- Verifies W3Schools logo presence
- Uses pytest fixtures
- Selenium WebDriver in Python

## Prerequisites

### Software Requirements
- Java JDK 11 or higher
- Maven 3.6+
- Python 3.8+
- Git
- Chrome browser
- Firefox browser
- Postman
- Apache JMeter

### Java Dependencies (Maven)
- Selenium WebDriver
- TestNG
- WebDriverManager (for automatic driver management)

### Python Dependencies
```bash
pip install selenium pytest pytest-html webdriver-manager
```

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd sdet-comprehensive-assignment
```

### 2. Java Maven Setup
```bash
cd java-programs
mvn clean install
```

### 3. Python Setup
```bash
cd python-programs
pip install -r requirements.txt
```

## Running the Tests

### Java Tests (Maven + TestNG)
```bash
cd java-programs
mvn clean test
```

### Python Tests (Pytest)
```bash
cd python-programs
pytest test_w3schools.py -v --html=report.html
```

### View TestNG Reports
After running Java tests, reports are available at:
```
java-programs/test-output/index.html
```

## Git Workflow

1. Create a new branch:
```bash
git checkout -b sdet-assignment
```

2. Add and commit changes:
```bash
git add .
git commit -m "Complete SDET comprehensive assignment"
```

3. Push to GitHub:
```bash
git push origin sdet-assignment
```

## API Testing (Postman)

Import the collection from `postman/REST_API_Collection.json`

### Test Cases Covered:
- **GET**: Retrieve object by ID (positive/negative)
- **POST**: Create new object (positive/negative)
- **PUT**: Update existing object (positive/negative)
- **DELETE**: Delete object (positive/negative)

### Expected HTTP Status Codes:
- 200: OK (GET, PUT)
- 201: Created (POST)
- 204: No Content (DELETE)
- 404: Not Found (invalid IDs)
- 400: Bad Request (invalid data)

## JMeter Testing

Open the test plan: `jmeter/MakeMyTrip_TestPlan.jmx`

### Configuration:
- Thread Group: 10 users, 2 seconds ramp-up
- Assertions: Response code 200
- Listeners: View Results Tree, Assertion Results

## Notes

- For Selenium tests, WebDriverManager automatically downloads and configures browser drivers
- Ensure all browsers are updated to latest versions
- Python tests use pytest fixtures for setup and teardown
- All tests follow best practices with proper assertions and validations

## Author

Created as part of SDET Basic Level Comprehensive Assignment

## License

This project is for educational purposes.
