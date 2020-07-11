package de.debuglevel.omnitrackerinternals.entity.field

import de.debuglevel.omnitrackerdatabasebinding.field.Field
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class FieldService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.field.FieldService
) : EntityService<Field>() {
    private val logger = KotlinLogging.logger {}
}