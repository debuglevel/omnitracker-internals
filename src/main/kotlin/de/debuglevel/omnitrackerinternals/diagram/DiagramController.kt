package de.debuglevel.omnitrackerinternals.diagram

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/diagrams")
@Tag(name = "diagrams")
class DiagramController(
    private val diagramService: DiagramService
) {
    private val logger = KotlinLogging.logger {}

    @Get("/entityrelationship/", produces = ["image/svg+xml"])
    fun getOne(): String {
        logger.debug("Called getOne()")

        return diagramService.generateEntityRelationshipDiagramSvg()
    }
}