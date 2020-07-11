package de.debuglevel.omnitrackerinternals.entity.script

import de.debuglevel.omnitrackerdatabasebinding.script.Script
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class ScriptService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.script.ScriptService
) : EntityService<Script>() {
    private val logger = KotlinLogging.logger {}
}