package com.gersondev.api

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
internal class MessageControllerTest {

    @field:Client("/")
    @Inject
    lateinit var client: HttpClient

    @Test
    internal fun `should greet with message`() {
        val name = "gerson"
        val response = client.toBlocking().retrieve("/message/greet/$name")

        Assertions.assertEquals("Hola $name", response)
    }

    @Test
    internal fun `should count`() {
        val response = client.toBlocking().retrieve("/message/count")

        Assertions.assertEquals("[1,2,3,4,5]", response)
    }
}