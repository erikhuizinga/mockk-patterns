package com.github.erikhuizinga.mockk.junit5

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.Extension

/**
 * Apply this [Extension] to automatically apply [MockkClearExtension] and [MockkUnmockExtension].
 * These extensions clear all MockK mocks after every unit test and unmock all MockK mocks after the
 * test class.
 */
class MockkClearUnmockExtension :
    AfterEachCallback by MockkClearExtension(),
    AfterAllCallback by MockkUnmockExtension()

@Deprecated(
    message = "Renamed to MockkClearUnmockExtension, will be removed in an upcoming release",
    replaceWith = ReplaceWith("MockkClearUnmockExtension")
)
class MockkExtension :
    AfterEachCallback by MockkClearExtension(),
    AfterAllCallback by MockkUnmockExtension()
