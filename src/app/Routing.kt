package app.app
import app.controllers.ExampleController
import io.ktor.routing.*
import org.kodein.di.ktor.controller.controller

fun Routing.apiRoute() {
    route("/api/v1") {
        controller("/example") { ExampleController(application) }
    }
}