package de.debuglevel.omnitrackerinternals.entity.script

import de.debuglevel.omnitrackerdatabasebinding.script.Script
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/scripts")
@Tag(name = "scripts")
@Secured(SecurityRule.IS_AUTHENTICATED)
class ScriptController(
    override val entityService: ScriptService
) :
    EntityController<Script>() {
    private val logger = KotlinLogging.logger {}

}