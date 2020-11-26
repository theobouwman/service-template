package app.clients

import io.ktor.application.*
import io.ktor.client.request.*

class ExampleAPIClient(application: Application) {

    private val url by lazy {
        application.environment.config.property("services.test_api_client.url").getString()
    }

    suspend fun getExample(): String {
        return HttpClient.get(url)
    }
}