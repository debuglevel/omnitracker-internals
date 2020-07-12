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

    @Get("/entityrelationship/svg/", produces = ["image/svg+xml"])
    fun getOneSvg(): String {
        logger.debug("Called getOneSvg()")

        return diagramService.generateEntityRelationshipDiagramSvg()
    }

    @Get("/entityrelationship/yed/", produces = ["application/graphml+xml"])
    fun getOneYedGraphml(): String {
        logger.debug("Called getOneYedGraphml()")

        return diagramService.generateEntityRelationshipDiagramYed()
    }
}