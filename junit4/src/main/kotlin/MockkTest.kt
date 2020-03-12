package com.github.erikhuizinga.mockk.junit4

import org.junit.ClassRule
import org.junit.Rule

/**
 * Extend this class to automatically apply [MockkTestClassRule] and [MockkTestRule]. These rules
 * clear all MockK mocks after every unit test and unmock all MockK mocks after the test class.
 */
abstract class MockkTest {
    companion object {
        // Unfortunately @JvmStatic is required, so this must be a class and cannot be an interface
        @JvmStatic
        @get:ClassRule
        val mockkTestClassRule = MockkTestClassRule()
    }

    @get:Rule
    val mockkTestRule = MockkTestRule()
}
