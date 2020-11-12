package app.controllers

import app.models.Example
import app.models.Response
import app.services.ExampleService
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance

class ExampleController(application: Application): Controller(application) {
    private val exampleService: ExampleService by instance()

    override fun Route.getRoutes() {
        get("/") {
            val examples = exampleService.getAllExamples()
            call.respond(Response(200, data = examples))
        }
        post("/") {
            val bookRequest = call.receive<Example>()
            exampleService.addExample(bookRequest)
            call.respond(HttpStatusCode.Accepted)
        }

        delete("book/{id}") {
            val exampleId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
            exampleService.deleteExample(exampleId)
            call.respond(HttpStatusCode.OK)
        }
        authenticate {
            get("/protected") {

                val id = call.authentication.principal<JWTPrincipal>()?.payload?.getClaim("name")?.asString()
                call.respond("protected $id")
            }
        }
    }
}