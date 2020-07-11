package de.debuglevel.omnitrackerinternals.entity.webserviceconsumercallprofile

import de.debuglevel.omnitrackerdatabasebinding.webserviceconsumercallprofile.WebServiceConsumerCallProfile
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class WebServiceConsumerCallProfileService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.webserviceconsumercallprofile.WebServiceConsumerCallProfileService
) : EntityService<WebServiceConsumerCallProfile>() {
    private val logger = KotlinLogging.logger {}
}