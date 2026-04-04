# TypeRunner - Group 01

## Authors

* Christian Tamayo
* Noh Woldetinsae
* Sahej Sethi
* Olorunfemi Martins
* Tanya Sahota

---

## Overview

TypeRunner is a Java-based typing game designed to help users improve their typing speed and accuracy in an enjoyable way. The application includes statistics tracking so users can monitor their progress, as well as a competitive leaderboard system.

---

## Dependencies

To run this project, ensure you have the following installed:

* **Java Development Kit (JDK)** (version 23 or newer)
* **Apache Maven**

---

## Libraries

* JavaFX for GUI
* JUnit for Testing
---

## Build & Run Instructions (Recommended to Use Maven)

1. Open a terminal in the project root directory.
2. Run the following command:

```
mvn clean javafx:run
```

This will:

* Clean previous builds
* Compile the project
* Launch the JavaFX application

The pom.xml file has all configurations needed for javaFX and module paths, so no further action is needed. 

### Note Without Maven

There is a jar file in the submitted zip under target folder. If you really don't want to use Maven you will the need to install the JavaFX SDK and run the following: 
```
java --module-path /path/to/javafx/lib \
     --add-modules javafx.controls,javafx.fxml \
     -jar typerunner-1.0.jar
```

---

## Debugging

* Running through an IDE with Maven support is recommended for easier setup and debugging.
* Make sure Maven is properly installed and available in your system PATH.

---

## Notes / References

* GUI Screens (fxml files) built with the help of Scene Builder. 
https://gluonhq.com/products/scene-builder/
* Passkey for the Admin Screen is: 1234
* You can use the dummy account ("admin", "password") for testing.
* In the zip file submission, you can find classes, JavaDoc, and the .jar under target. 
