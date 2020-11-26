package app.services

import app.clients.ExampleAPIClient
import app.models.Example
import app.models.ExampleEntity
import org.jetbrains.exposed.sql.transactions.transaction

class ExampleService(private val exampleApiClient: ExampleAPIClient) {

    suspend fun getFromAPI(): String {
        val exampleResponse = exampleApiClient.getExample()
        return exampleResponse
    }

    fun getAllExamples(): Iterable<Example> = transaction {
        ExampleEntity.all().map(ExampleEntity::toExample)
    }

    fun addExample(example: Example) = transaction {
        ExampleEntity.new {
            this.title = example.title
        }
    }

    fun deleteExample(exampleId: Int) = transaction {
        ExampleEntity[exampleId].delete()
    }
}