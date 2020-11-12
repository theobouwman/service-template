package app.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Examples : IntIdTable() {
    val title = varchar("title", 255)
}

class ExampleEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ExampleEntity>(Examples)

    var title by Examples.title

    override fun toString(): String = "Book($title)"

    fun toExample() = Example(id.value, title)
}

data class Example(
    val id: Int,
    val title: String,
)