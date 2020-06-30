package de.debuglevel.omnitrackerinternals.webserviceconsumerprofile

import de.debuglevel.omnitrackerdatabasebinding.webservice.WebServiceConsumerProfile
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/webserviceconsumerprofiles")
@Tag(name = "webserviceconsumerprofiles")
class WebServiceConsumerProfileController(private val webServiceConsumerProfileService: WebServiceConsumerProfileService) {
    private val logger = KotlinLogging.logger {}

    @Get("/")
    fun getList(): List<WebServiceConsumerProfile> {
        logger.debug("Called getList()")

        return webServiceConsumerProfileService.getAll()
    }
}