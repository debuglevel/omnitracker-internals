package de.debuglevel.omnitrackerinternals.diagram

import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class DiagramService(
    private val omnitrackerEntityReader: OmnitrackerEntityReader
) {
    private val logger = KotlinLogging.logger {}

    fun generateEntityRelationshipDiagramSvg(): String {
        return SvgVisualizationWriter(
            omnitrackerEntityReader.entities,
            omnitrackerEntityReader.relationships
        ).generate()
    }
}