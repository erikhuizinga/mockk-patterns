package com.github.erikhuizinga.mockk.junit5

import io.mockk.clearAllMocks
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.Extension
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Apply this [Extension] to clear all Mockk mocks after each unit test.
 */
class MockkClearExtension : AfterEachCallback {
    override fun afterEach(context: ExtensionContext?) = clearAllMocks()
}
