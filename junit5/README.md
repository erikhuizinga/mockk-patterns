[![Download from Maven Central](https://img.shields.io/badge/dynamic/xml?color=darkgreen&label=Maven%20Central&prefix=com.github.erikhuizinga:mockk-junit5:&query=.%2F%2Flatest&url=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fgithub%2Ferikhuizinga%2Fmockk-junit5%2Fmaven-metadata.xml)](https://search.maven.org/artifact/com.github.erikhuizinga/mockk-junit5)

# `mockk-junit5`

MockK Patterns for JUnit 5

## Installation

<details open>

<summary>
Gradle Kotlin DSL
</summary>

```kotlin
testImplementation("com.github.erikhuizinga:mockk-junit5:$LATEST_VERSION")
```

</details>

<details>

<summary>
Gradle Groovy DSL
</summary>

```groovy
testImplementation "com.github.erikhuizinga:mockk-junit5:$LATEST_VERSION"
```

</details>

## Usage

### MockK JUnit 5 extensions

See the JUnit 5 user guide to learn more about [registering extensions](https://junit.org/junit5/docs/5.6.0/user-guide/#extensions-registration).

#### `MockkClearUnmockExtension`

Apply this `Extension` to automatically apply `MockkClearExtension` and `MockkUnmockExtension`.
These extensions clear all MockK mocks after every unit test and unmock all MockK mocks after the test class.

#### `MockkClearExtension`

Apply this `Extension` to clear all Mockk mocks after each unit test.

#### `MockkUnmockExtension`

Apply this `Extension` to unmock all Mockk mocks after the test class.

### Example

Take a look at [ExampleTestSuite](src/test/kotlin/com/github/erikhuizinga/mockk/junit5/example/ExampleTestSuite.kt) for an example to use `MockkClearUnmockExtension` with an extensive description of the involved MockK and JUnit 5 mechanics.
