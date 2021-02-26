package de.debuglevel.omnitrackerinternals.entity.autocalculation

import de.debuglevel.omnitrackerdatabasebinding.autocalculation.Autocalculation
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/autocalculations")
@Tag(name = "autocalculation")
@Secured(SecurityRule.IS_AUTHENTICATED)
class AutocalculationController(
    override val entityService: AutocalculationService
) :
    EntityController<Autocalculation>() {
    private val logger = KotlinLogging.logger {}
}