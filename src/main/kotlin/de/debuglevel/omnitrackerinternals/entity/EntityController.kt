package de.debuglevel.omnitrackerinternals.entity

import de.debuglevel.omnitrackerdatabasebinding.entity.Entity
import io.micronaut.http.annotation.Get
import mu.KotlinLogging

abstract class EntityController<T : Entity> {
    private val logger = KotlinLogging.logger {}

    protected abstract val entityService: EntityService<T>

    @Get("/")
    fun getList(): List<T> {
        logger.debug("Called getList()")

        return entityService.getAll()
    }

    @Get("/{id}")
    fun getOne(id: Int): T? {
        logger.debug("Called getOne(id=$id)")

        return entityService.get(id)
    }
}