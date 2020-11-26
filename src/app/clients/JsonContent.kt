package app.clients

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.ktor.content.*
import io.ktor.http.*

object JsonContent {
    private val mapper = jacksonObjectMapper()
    operator fun invoke(json: Any): TextContent {
        return TextContent(
            mapper.writeValueAsString(json),
            contentType = ContentType.Application.Json
        )
    }
}