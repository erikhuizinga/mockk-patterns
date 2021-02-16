[![Download from Maven Central](https://img.shields.io/badge/dynamic/xml?color=brightgreen&label=Maven%20Central&prefix=com.github.erikhuizinga:mockk-junit4:&query=.%2F%2Flatest&url=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fgithub%2Ferikhuizinga%2Fmockk-junit4%2Fmaven-metadata.xml)](https://search.maven.org/artifact/com.github.erikhuizinga/mockk-junit4)

# `mockk-junit4`

MockK Patterns for JUnit 4

## Installation

Artifacts are hosted on the [Maven Central repository](https://search.maven.org/artifact/com.github.erikhuizinga/mockk-junit4).

### Gradle Installation

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.github.erikhuizinga:mockk-junit4:$LATEST_VERSION")
}
```

## Usage

### `MockkTest`

Extend this class to automatically apply `MockkTestClassRule` and `MockkTestRule`.
These rules clear all MockK mocks after every unit test and unmock all MockK mocks after the test class.

### MockK JUnit 4 test rules

#### `MockkTestClassRule`

Class rule to unmock all MockK mocks so that they don't leak between unit test classes.

#### `MockkTestRule`

Rule to clear all MockK mocks so that their state doesn't leak between unit test functions.

### Example

Take a look at [ExampleTestSuite](src/test/kotlin/com/github/erikhuizinga/mockk/junit4/example/ExampleTestSuite.kt) for an example to use `MockkTest` with an extensive description of the involved MockK and JUnit 4 mechanics.
