[![Download](https://api.bintray.com/packages/erikhuizinga/maven/mockk-junit4/images/download.svg)](https://bintray.com/erikhuizinga/maven/mockk-junit4/_latestVersion)

# `mockk-junit4`

MockK Patterns for JUnit 4

## Installation

<details open>

<summary>
Gradle Kotlin DSL
</summary>

```kotlin
testImplementation("com.github.erikhuizinga:mockk-junit4:$LATEST_VERSION")
```

</details>

<details>

<summary>
Gradle Groovy DSL
</summary>

```groovy
testImplementation "com.github.erikhuizinga:mockk-junit4:$LATEST_VERSION"
```

</details>

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
