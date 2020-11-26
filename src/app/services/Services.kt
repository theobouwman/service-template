package app.services

import app.clients.ExampleAPIClient
import io.ktor.application.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

fun DI.MainBuilder.bindServices(application: Application) {
    bind<ExampleAPIClient>() with singleton { ExampleAPIClient(application) }
    bind<ExampleService>() with singleton { ExampleService(instance()) }
}