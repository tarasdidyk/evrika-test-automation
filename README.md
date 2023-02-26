### Evrika-test-automation

### Overview:

This project is a test automation framework developed for https://evrika.wezom.agency/ website using Java 11, TestNG, Lombok, Maven, Selenide and Selenium. The purpose of this project is to automate the testing process and ensure the functionality of the website.

### Technologies used:

* Java 11
* TestNG
* Lombok
* Maven
* Selenide
* Selenium
* Allure 
* Assertj

### Configuration:

The project is configured using the pom.xml file. Dependencies for each technology used are specified in this file.

### Adding new test:

You can add new tests by adding a new test class in the test folder. TestNG annotations should be used for writing tests.

###  Adding new pages/modals:

You can add new pages/modals by adding a new class in the pages/modals folders. Each class should contain methods for accessing elements on the page/modal and methods for performing actions on those elements.

### Changing test run configuration:

To change the test run configuration, browser configuration or other configurations, you can modify the TestRunner class.

### Running tests:

Tests can be run by using the run test command inside the test class or by using the `mvn test` command.

### Generating and opening allure report:

You can generate and open an allure report by using the command `mvn allure:serve`. This will generate a report in the target/site/allure-maven-plugin directory and open it in the default browser.

### Note:

This project is only for testing purposes and should not be used for any other purpose.