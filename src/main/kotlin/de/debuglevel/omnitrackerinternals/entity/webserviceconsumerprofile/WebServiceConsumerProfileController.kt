package de.debuglevel.omnitrackerinternals.entity.webserviceconsumerprofile

import de.debuglevel.omnitrackerdatabasebinding.webserviceconsumerprofile.WebServiceConsumerProfile
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/webserviceconsumerprofiles")
@Tag(name = "webserviceconsumerprofiles")
class WebServiceConsumerProfileController(
    override val entityService: WebServiceConsumerProfileService
) :
    EntityController<WebServiceConsumerProfile>() {
    private val logger = KotlinLogging.logger {}

}