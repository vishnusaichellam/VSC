# Selenium Automation Framework

## Overview

This project is a Selenium automation framework developed using Java, Selenium WebDriver, TestNG, and Maven.

The framework demonstrates web UI automation, reusable test components, structured test organization, and automated browser interactions. It includes practice pages for testing different browser and web-element behaviors.

## Technologies Used

* **Java** — Programming language
* **Selenium WebDriver** — Browser automation
* **TestNG** — Test execution and test organization
* **Maven** — Build and dependency management
* **HTML** — Local test pages used for automation scenarios
* **Git and GitHub** — Version control and project hosting

## Key Features

* Browser automation using Selenium WebDriver
* Web element interaction and validation
* Page Object Model (POM) design
* Reusable page and test components
* Explicit waits and synchronization
* Handling JavaScript alerts and prompts
* Working with frames and nested iframes
* Handling multiple browser windows and tabs
* Testing challenging interaction scenarios, including intercepted clicks
* Maven-based project configuration
* TestNG-based test organization and execution

## Project Structure

```text
Selenium-Automation-Framework/
├── src/
│   ├── main/
│   └── test/
├── test-pages/
├── pom.xml
├── testng.xml
├── .gitignore
├── base-test-demo
├── child.html
├── click_intercepted.html
├── inner.html
├── multiple_windows.html
├── nested_iframe.html
├── outer.html
└── prompt_alert.html
```

*Note: The structure above illustrates the main files visible in the repository. Your actual package names and source folders may differ.*

## Prerequisites

Before running the project, install:

1. Java Development Kit (JDK)
2. IntelliJ IDEA or another Java IDE
3. Git
4. Maven, if you are not using the Maven wrapper or your IDE's Maven integration

Make sure Java is configured correctly on your system.

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/vishnusaichellam/VSC.git
```

### 2. Open the Project

Open the cloned project folder in IntelliJ IDEA.

### 3. Load Maven Dependencies

Open the `pom.xml` file and reload the Maven project so that the required dependencies are downloaded.

### 4. Run the Tests

Use the TestNG configuration in IntelliJ IDEA or run the test suite through Maven:

```bash
mvn test
```

The exact execution command may depend on your Maven and TestNG configuration.

## Skills Demonstrated

This project demonstrates practical skills in:

* Java programming
* Selenium WebDriver automation
* TestNG test execution
* Maven project configuration
* Page Object Model principles
* Browser synchronization and waits
* Handling alerts, frames, and multiple windows
* Web UI automation testing
* Git and GitHub version control

## Future Improvements

Potential improvements include:

* Adding screenshots for failed tests
* Integrating automated test execution with Jenkins
* Adding structured logging and reporting
* Integrating the framework into a CI/CD pipeline
* Expanding test coverage for additional web application scenarios

## Author

**GitHub:** [vishnusaichellam](https://github.com/vishnusaichellam)
