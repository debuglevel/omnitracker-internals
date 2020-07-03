package de.debuglevel.omnitrackerinternals.webserviceconsumercallprofile

import de.debuglevel.omnitrackerdatabasebinding.webservice.WebServiceConsumerCallProfile
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class WebServiceConsumerCallProfileService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.webservice.WebServiceConsumerCallProfileService
) : EntityService<WebServiceConsumerCallProfile>() {
    private val logger = KotlinLogging.logger {}
}