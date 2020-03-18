package com.github.erikhuizinga.mockk.junit5.example

import com.github.erikhuizinga.mockk.junit5.MockkClearUnmockExtension
import com.github.erikhuizinga.mockk.junit5.example.ExampleTestSuite.ExampleMockkClearUnmockExtensionTest
import com.github.erikhuizinga.mockk.junit5.example.ExampleTestSuite.YourObjectIsNoLongerMockedTest
import io.mockk.MockKException
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.extension.ExtendWith

/**
 * This will be mocked in the example.
 */
object YourObject

/**
 * In this test class the order of nested classes and unit tests is fixed for the example's
 * purposes.
 *
 * [@ExtendWith(MockkClearUnmockExtension::class)][MockkClearUnmockExtension] ensures all MockK mock
 * state is cleared between unit tests and all mocks are unmocked between test classes.
 *
 * The first test class [ExampleMockkClearUnmockExtensionTest] runs.
 * First we mock [YourObject].
 * Because mocking may be expensive and/or slow, we only do this once by using
 * [TestInstance.Lifecycle.PER_CLASS] and [@BeforeAll][BeforeAll].
 *
 * Then the unit tests in `ExampleMockkClearUnmockExtensionTest` run.
 * Test 1 mocks [YourObject.toString] and then asserts and verified this.
 * Test 2 is in the same test class, so `YourObject` is still mocked, but any mock state from test 1
 * should not leak into test 2 (i.e. the mock should be cleared); this is tested in test 2.
 *
 * The next test class [YourObjectIsNoLongerMockedTest] should not be influenced by the first test
 * class and its unit tests.
 * Test 3 asserts and verifies this.
 * However, the verification cannot be done, because `YourObject` is no longer a mock.
 * Instead, MockK throws a [MockKException] and this is asserted.
 */
class ExampleTestSuite {
    private val string = "string"

    @ExtendWith(MockkClearUnmockExtension::class) // From mockk-junit5, remove this to leak mock state!
    @Nested
    @TestMethodOrder(MethodOrderer.Alphanumeric::class)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class ExampleMockkClearUnmockExtensionTest {
        @BeforeAll
        fun `before all`() {
            // This mock should not leak between classes and unit tests!
            mockkObject(YourObject)
        }

        @Test
        fun `test 1`() {
            every { YourObject.toString() } returns string // Mock toString
            assertEquals(string, YourObject.toString())
            verify(exactly = 1) { YourObject.toString() }
        }

        @Test
        fun `test 2`() {
            assertNotEquals(string, YourObject.toString()) // toString is no longer mocked!
            verify(exactly = 1) { YourObject.toString() } // YourObject still is mocked!
        }
    }

    @Nested
    inner class YourObjectIsNoLongerMockedTest {
        @Test
        fun `test 3`() {
            assertNotEquals(string, YourObject.toString()) // toString is no longer mocked!
            assertThrows<MockKException> {
                verify(exactly = 1) { YourObject.toString() } // YourObject is no longer mocked!
            }
        }
    }
}
