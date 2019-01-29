# Web UI Automation

This project includes 5 tests for the-internet.herokuapp.com.

The technology stack that is used:
* Selenium Webdriver
 * JAVA
 * Maven 


### Prerequisites

In order to use these tests you need to install following software:


* [Maven](https://maven.apache.org/)
* [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (JDK)


### Installing

After cloning the project from Githab, you can either build it in your IDE (IntelliJ IDEA or Eclipse) or just go to the project folder and type in command line "mvn clean install".

## Parameters
At the catalogue **\src\test\resources** you can find **selenium.properties** file where you can specify base URL of the project, reports folder and browser where the test is executed. 

## Running the tests

You can execute tests either in IDE or just go to the project folder and type in command line "mvn test"  


## Results and reports

After every execution a folder named with timestamp is created where you can find HTML reports along with some statistics and with screenshots in cases of failed tests. 

## Author

* **Alexander Ognev**  <avogneff@gmail.com>

