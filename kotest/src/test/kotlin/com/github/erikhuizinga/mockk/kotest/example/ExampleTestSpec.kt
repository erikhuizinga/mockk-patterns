package com.github.erikhuizinga.mockk.kotest.example

import com.github.erikhuizinga.mockk.kotest.MockkTestListener
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK

class Client {
    fun get() = "example"
}

class ExampleTestSpec : StringSpec() {

    override fun listeners() = listOf(MockkTestListener())

    @RelaxedMockK
    private lateinit var client: Client

    init {
        "example test" {
            every { client.get() } returns "mocked-response"

            val res = client.get()

            res shouldBe "mocked-response"
        }
    }
}
