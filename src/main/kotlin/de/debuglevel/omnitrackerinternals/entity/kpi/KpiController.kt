package de.debuglevel.omnitrackerinternals.entity.kpi

import de.debuglevel.omnitrackerdatabasebinding.kpi.Kpi
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/kpis")
@Tag(name = "kpis")
@Secured(SecurityRule.IS_AUTHENTICATED)
class KpiController(
    override val entityService: KpiService
) :
    EntityController<Kpi>() {
    private val logger = KotlinLogging.logger {}
}