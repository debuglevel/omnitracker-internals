package de.debuglevel.omnitrackerinternals.entity.autocalculation

import de.debuglevel.omnitrackerdatabasebinding.autocalculation.Autocalculation
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class AutocalculationService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.autocalculation.AutocalculationService
) : EntityService<Autocalculation>() {
    private val logger = KotlinLogging.logger {}
}