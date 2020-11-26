package app

import app.controllers.ExampleController
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.ktor.controller.controller

fun Routing.commonRoutes() {
    get("/health") {
        call.respondText("OK")
    }
}

fun Routing.apiV1Routes() {
    route("/api/v1") {
        controller("/example") { ExampleController(application) }
    }
}