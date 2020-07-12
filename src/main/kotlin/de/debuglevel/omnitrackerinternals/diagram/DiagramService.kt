package de.debuglevel.omnitrackerinternals.diagram

import de.debuglevel.omnitrackerinternals.diagram.formats.SvgVisualizationWriter
import de.debuglevel.omnitrackerinternals.diagram.formats.YedVisualizationWriter
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

    fun generateEntityRelationshipDiagramYed(): String {
        return YedVisualizationWriter(
            omnitrackerEntityReader.entities,
            omnitrackerEntityReader.relationships
        ).generate()
    }
}