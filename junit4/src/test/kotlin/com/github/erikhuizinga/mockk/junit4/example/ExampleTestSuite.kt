package com.github.erikhuizinga.mockk.junit4.example

import com.github.erikhuizinga.mockk.junit4.MockkTest
import io.mockk.MockKException
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.junit.runners.Suite

/**
 * In this test suite the order of suite classes and unit tests is fixed for the example's
 * purposes.
 *
 * Extending [MockkTest] ensures all MockK mock state is cleared between unit tests and all mocks
 * are unmocked between test classes.
 *
 * The first test class [ExampleMockkTest] runs.
 * First we mock [YourObject].
 * Because mocking may be expensive and/or slow, we only do this once by using
 * [@BeforeClass][BeforeClass] in the `companion object`;
 * in the class body itself it would run for every unit test.
 *
 * Then the unit tests in `ExampleMockkTest` run.
 * Test 1 mocks [YourObject.toString] and then asserts and verifies this.
 * Test 2 is in the same test class, so `YourObject` is still mocked, but any mock state from test 1
 * should not leak into test 2 (i.e. the mock should be cleared); this is tested in test 2.
 *
 * The next test class [YourObjectIsNoLongerMockedTest] should not be influenced by the first test
 * class and its unit tests.
 * Test 3 asserts and verifies this.
 * However, the verification cannot be done, because `YourObject` is no longer a mock.
 * Instead, MockK throws a [MockKException] and this is asserted.
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(ExampleMockkTest::class, YourObjectIsNoLongerMockedTest::class)
class ExampleTestSuite

/**
 * This will be mocked in the example.
 */
object YourObject

private const val string = "string"

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExampleMockkTest : MockkTest() { // Remove `: MockkTest()` to leak mock state!
    companion object {
        @JvmStatic
        @BeforeClass
        fun `before class`() {
            mockkObject(YourObject)
        }
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

class YourObjectIsNoLongerMockedTest {
    @Test
    fun `test 3`() {
        assertNotEquals(string, YourObject.toString()) // toString is no longer mocked!
        assertThrows(MockKException::class.java) {
            verify(exactly = 1) { YourObject.toString() } // YourObject is no longer mocked!
        }
    }
}
