package de.debuglevel.omnitrackerinternals.webserviceconsumerprofile

import de.debuglevel.omnitrackerdatabasebinding.webservice.WebServiceConsumerProfile
import de.debuglevel.omnitrackerinternals.omnitrackerdatabasebinding.OmnitrackerService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class WebServiceConsumerProfileService(
    private val omnitrackerService: OmnitrackerService
) {
    private val logger = KotlinLogging.logger {}

    fun getAll(): List<WebServiceConsumerProfile> {
        return omnitrackerService.omnitrackerDatabase.webServiceConsumerProfiles.map { it.value }
    }
}