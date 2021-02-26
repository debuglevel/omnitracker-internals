package de.debuglevel.omnitrackerinternals.entity.kpi

import de.debuglevel.omnitrackerdatabasebinding.kpi.Kpi
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class KpiService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.kpi.KpiService
) : EntityService<Kpi>() {
    private val logger = KotlinLogging.logger {}
}