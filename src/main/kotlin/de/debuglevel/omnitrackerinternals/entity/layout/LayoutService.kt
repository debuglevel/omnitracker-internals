package de.debuglevel.omnitrackerinternals.entity.layout

import de.debuglevel.omnitrackerdatabasebinding.layout.Layout
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class LayoutService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.layout.LayoutService
) : EntityService<Layout>() {
    private val logger = KotlinLogging.logger {}
}