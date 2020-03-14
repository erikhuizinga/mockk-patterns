package com.github.erikhuizinga.mockk.junit4

import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import org.junit.ClassRule
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Unmock all MockK mocks so that they don't leak between unit test classes.
 * Apply this as a [@ClassRule][ClassRule].
 */
class MockkTestClassRule : TestWatcher() {
    override fun finished(description: Description?) = unmockkAll()
}

/**
 * Clear all MockK mocks so that their state doesn't leak between unit test functions.
 * Apply this as a [@Rule][Rule].
 */
class MockkTestRule : TestWatcher() {
    override fun finished(description: Description?) = clearAllMocks()
}
