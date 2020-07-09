package de.debuglevel.omnitrackerinternals.entity

import de.debuglevel.omnitrackerdatabasebinding.entity.Entity
import de.debuglevel.omnitrackerdatabasebinding.entity.EntityService
import mu.KotlinLogging

abstract class EntityService<T : Entity> {
    private val logger = KotlinLogging.logger {}

    protected abstract val entityService: EntityService<T>

    fun getAll(): List<T> {
        logger.debug { "Getting all entities..." }
        val list = entityService.getAll().map { it.value }
        logger.debug { "Got ${list.size} entities" }
        return list
    }

    fun get(id: Int): T? {
        logger.debug { "Getting entity id='$id'..." }
        val entity = entityService.get(id)
        logger.debug { "Got entity: $entity" }
        return entity
    }
}