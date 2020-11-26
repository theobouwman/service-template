package app

import app.controllers.ExampleController
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.kodein.di.instance
import org.kodein.di.ktor.controller.controller
import org.kodein.di.ktor.di

fun Routing.healthCheckRoute() {
    get("/health") {
        call.respondText("OK")
    }
}

fun Routing.metrics() {
    val registry: PrometheusMeterRegistry by di().instance()

    get("/metrics") {
        call.respondText {
            registry.scrape()
        }
    }
}

fun Routing.apiV1Routes() {
    route("/api/v1") {
        controller("/example") { ExampleController(application) }
    }
}