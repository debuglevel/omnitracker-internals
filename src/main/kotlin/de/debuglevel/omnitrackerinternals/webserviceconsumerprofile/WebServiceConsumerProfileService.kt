package de.debuglevel.omnitrackerinternals.webserviceconsumerprofile

import de.debuglevel.omnitrackerdatabasebinding.webservice.WebServiceConsumerProfile
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class WebServiceConsumerProfileService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.webservice.WebServiceConsumerProfileService
) : EntityService<WebServiceConsumerProfile>() {
    private val logger = KotlinLogging.logger {}
}