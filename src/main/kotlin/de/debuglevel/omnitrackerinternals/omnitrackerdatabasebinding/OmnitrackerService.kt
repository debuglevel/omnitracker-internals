package de.debuglevel.omnitrackerinternals.omnitrackerdatabasebinding

import de.debuglevel.omnitrackerdatabasebinding.OmnitrackerDatabase
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class OmnitrackerService(val omnitrackerDatabase: OmnitrackerDatabase) {
    private val logger = KotlinLogging.logger {}
}