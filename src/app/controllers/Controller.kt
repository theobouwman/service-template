package app.controllers

import io.ktor.application.*
import org.kodein.di.instance
import org.kodein.di.ktor.controller.AbstractDIController

abstract class Controller(application: Application) : AbstractDIController(application) {
}