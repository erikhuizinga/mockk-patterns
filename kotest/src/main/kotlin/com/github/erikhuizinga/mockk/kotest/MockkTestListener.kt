package com.github.erikhuizinga.mockk.kotest

import io.kotlintest.Spec
import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.extensions.TestListener
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.unmockkAll

/**
 * [TestListener] for kotest.
 * [beforeSpec] initializes mocks with annotations.
 * [afterTest] clears all mocks.
 * [afterSpec] cancels all mocks.
 */
class MockkTestListener : TestListener {
    override fun beforeSpec(spec: Spec) {
        MockKAnnotations.init(spec)
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }

    override fun afterSpec(spec: Spec) {
        unmockkAll()
    }
}
