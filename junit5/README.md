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

See the JUnit 5 user guide to learn more about [registering extension](https://junit.org/junit5/docs/5.6.0/user-guide/#extensions-registration). 

#### `MockkExtension`

Apply this `Extension` to automatically apply `MockkClearExtension` and `MockkUnmockExtension].
These extensions clear all MockK mocks after every unit test and unmock all MockK mocks after the test class.

#### `MockkClearExtension`

Apply this `Extension` to clear all Mockk mocks after each unit test.

#### `MockkUnmockExtension`

Apply this `Extension` to unmock all Mockk mocks after the test class.
