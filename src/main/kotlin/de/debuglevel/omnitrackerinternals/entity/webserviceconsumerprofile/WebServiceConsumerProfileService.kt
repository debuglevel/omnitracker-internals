package de.debuglevel.omnitrackerinternals.entity.webserviceconsumerprofile

import de.debuglevel.omnitrackerdatabasebinding.webserviceconsumerprofile.WebServiceConsumerProfile
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class WebServiceConsumerProfileService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.webserviceconsumerprofile.WebServiceConsumerProfileService
) : EntityService<WebServiceConsumerProfile>() {
    private val logger = KotlinLogging.logger {}
}