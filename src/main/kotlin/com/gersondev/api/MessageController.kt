package com.gersondev.api

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach

@Controller("/message")
class MessageController {

    @Get(produces = [MediaType.TEXT_PLAIN], uri = "/greet/{name}")
    fun greet(name: String): String {
        return "Hola $name"
    }

    @Get(uri = "/count")
    fun count(): Flow<Int> = flowOf(1, 2, 3, 4, 5).onEach { delay(1000) }
}