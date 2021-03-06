package de.debuglevel.omnitrackerinternals.entity.webserviceconsumercallprofile

import de.debuglevel.omnitrackerdatabasebinding.webserviceconsumercallprofile.WebServiceConsumerCallProfile
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/webserviceconsumercallprofiles")
@Tag(name = "webserviceconsumercallprofiles")
@Secured(SecurityRule.IS_AUTHENTICATED)
class WebServiceConsumerCallProfileController(
    override val entityService: WebServiceConsumerCallProfileService
) :
    EntityController<WebServiceConsumerCallProfile>() {
    private val logger = KotlinLogging.logger {}

}