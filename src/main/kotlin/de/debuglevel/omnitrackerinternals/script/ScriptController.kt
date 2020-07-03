package de.debuglevel.omnitrackerinternals.script

import de.debuglevel.omnitrackerdatabasebinding.script.Script
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/scripts")
@Tag(name = "scripts")
class ScriptController(
    override val entityService: ScriptService
) :
    EntityController<Script>() {
    private val logger = KotlinLogging.logger {}

}