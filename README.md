
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Yuhang Zhang               |
| Date         | 12/1/2025                  |
| Course       | Fall                       |
| Assignment # | 6                          |

# Assignment Overview
This assignment focuses on improving an earlier project by applying refactoring techniques and software design principles. The main objective is to identify structural issues, code smells, or maintainability problems in a previous assignment, and revise the design using clearer abstractions, better class organization, and appropriate design patterns. The goal is not to add new features, but to make the existing system easier to read, extend, and test.

In addition to refactoring the codebase, the assignment also requires documenting the improvements, providing UML diagrams that illustrate the new design, and writing JUnit tests to verify that the refactored code behaves correctly. Through this work, the project demonstrates a stronger understanding of object-oriented design, clean architecture, and professional software development practices.

# GitHub Repository Link:
https://github.com/YuhangZhangz/CS-665-Assignment-6 

# Implementation Description 

For each assignment, please answer the following:

- My refactored implementation is more flexible than the original version because the design now treats temperature and beverage types as separate, extendable components. The introduction of the `Temperature` enum makes it very easy to add new temperature options such as “WARM” or “ICED” without changing existing classes. In the same way, new beverages can be added simply by creating a new subclass of `Beverage` and implementing its `brew()` method. The `MachineController` does not need to be modified when new drink types are introduced, which helps reduce coupling and keeps the design open for extension but closed for modification.

- The refactored code is easier to understand because responsibilities are now clearly separated. Temperature handling is centralized in the `Beverage` class instead of being scattered across different classes. The use of readable types like `Temperature.HOT` and `Temperature.COLD` makes the code much more self-explanatory compared to the original boolean approach. The `MachineController` mainly coordinates beverage and condiment creation, so the flow of preparing a drink is straightforward to follow. Overall, the structure is cleaner, and each class has a clear purpose, making the system easier for others to read and maintain.

- Duplicated code was reduced by moving shared temperature logic into the `Beverage` base class. Both `Coffee` and `Tea` used to implement their own temperature checks, but now they inherit the `isHot()` and `getTemperatureEnum()` methods from the parent class. This avoids repeating the same logic across subclasses. Removing duplicated code is important because it makes the system easier to maintain; future changes only need to be made in one place, which reduces the chance of inconsistent behavior or bugs.

- This implementation uses the Template Method pattern. The `Beverage` class defines shared structure and behavior for all beverages, while subclasses like `Coffee` and `Tea` only provide their specific implementation of the `brew()` method. This pattern was chosen because it allows all beverage types to follow the same general process while still supporting drink-specific behavior. In addition, the `MachineController` works like a simplified Facade, providing a clean and unified interface for preparing a drink. This keeps client code simple, while hiding internal details such as temperature conversion and condiment configuration.

# Opportunities for Code Improvement: 

1. Temperature is represented by a boolean, which is too vague and inconvenient for expansion. The original code used `true/false` to represent whether the beverage was hot or cold. While it worked, it was very difficult to read; readers had no idea what `true` or `false` meant. Furthermore, adding new temperatures like "warm" or "ice" was impossible; it would require extensive modifications. Therefore, this is a significant area for improvement: temperature should be made into a more explicit type.

2. MachineController has too many responsibilities. The original MachineController handled too many things: it controlled beverage temperature, controlled ingredient addition, handled brewing, and even directly created new Coffee/Tea instances. All of this was crammed into one class, making it very bloated and difficult to read. Furthermore, if new beverage types were to be added later, this class had to be modified, making it very unmanageable.

3. The Condiment encapsulation is inadequate and prone to errors. The original Condiment class was merely a "data storage place," lacking complete validation logic, and its temperature was separate from the beverage's temperature, easily leading to inconsistencies between the two states. For example, the beverage might be set to cold, but the condiment might still be hot, resulting in a strange system state. Therefore, this aspect has room for improvement.

# Specific changes

1. The original code used `true/false` for temperature, which was not very intuitive and made it easy to forget which represented "hot" and which represented "cold". To make the code clearer and easier to extend in the future, I changed this boolean to a new `Temperature` enumeration class (containing both `HOT` and `COLD`). This makes the code easier to understand, instead of seeing `true` at a glance without knowing what it means. In addition, to avoid affecting older code, I retained the original boolean constructor, allowing it to automatically convert to the corresponding enumeration internally. Overall, this change makes the code more readable, cleaner, and less prone to errors.

2. In the `Beverage` base class, I added a `Temperature` field and provided a simple `isHot()` method, making it easier for all beverage subclasses to determine the temperature without writing repetitive code. The constructors for `Coffee` and `Tea` were also changed to use enumeration versions, while retaining the boolean version for compatibility with older tests. The logic for `brew()` is also clearer: hot drinks can be brewed, but brewing cold drinks will result in an error. These overall changes have made the hierarchy between beverage classes more logical and centralized the temperature determination rules, preventing them from being scattered across different parts of the class.

3. The original Condiment class lacked data validation and didn't manage temperature well, easily leading to inconsistencies between beverage and condiment temperatures. In the refactoring, I added range checks (0–3) for milk and sugar, and changed the Condiment's temperature to be managed using a Temperature enumeration. In the MachineController, when the temperature is modified, the Condiment's temperature is automatically synchronized, avoiding inconsistencies between hot and cold states. The MachineController previously handled too many responsibilities; now, with clearer temperature management and more reasonable state encapsulation, the overall logic is clearer, and the controller code is less bloated.




# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




