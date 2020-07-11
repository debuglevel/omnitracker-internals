package de.debuglevel.omnitrackerinternals.diagram

import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class DiagramService(
    private val omnitrackerReader: OmnitrackerReader
) {
    private val logger = KotlinLogging.logger {}

    fun generateEntityRelationshipDiagramSvg(): String {
        return SvgDotWriter(omnitrackerReader.entities, omnitrackerReader.relationships).generate()
    }
}