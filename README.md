# Cucumber3rdGroup2025

This project is an automation testing framework built using **Cucumber**, **Selenium WebDriver**, and **TestNG**. It supports Behavior Driven Development (BDD) and provides detailed test execution reports using **Extent Reports** and **Allure Reports**.

## 🛠 Tech Stack

- **Language:** Java 11
- **Build Tool:** Maven
- **BDD Framework:** Cucumber (v7.27.2)
- **Test Runner:** TestNG
- **Web Automation:** Selenium WebDriver (v4.35.0)
- **Reporting:**
  - Extent Reports (via Grasshopper adapter)
  - Allure Reports

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed on your machine:
- [Java JDK 11+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd Cucumber3rdGroup2025
   ```
3. Install dependencies:
   ```sh
   mvn clean install
   ```

## 🏃 Running Tests

You can run the tests using Maven or directly from your IDE.

### Using Maven
To execute all tests:
```sh
mvn test
```

### Using TestNG
Right-click on the `testng.xml` file (if available) or the runner class and select **Run**.

## 📊 Reporting

### Extent Reports
After execution, Extent Reports are generated in the `test-output` or `target` directory (depending on configuration). Open the `.html` file in a browser to view the results.

### Allure Reports
To generate and view Allure reports:
1. Run the tests.
2. Generate the report:
   ```sh
   allure serve allure-results
   ```

## 📂 Project Structure

```
Cucumber3rdGroup2025
│── src/test/java        # Step definitions, runners, utils and page objects
│── src/test/resources   # Feature files and configurations
│── target               # Compiled classes and reports
│── pom.xml              # Maven dependencies
│── README.md            # Project documentation
```

## 🤝 Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.
