package de.debuglevel.omnitrackerinternals.diagram

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import mu.KotlinLogging
import java.io.ByteArrayOutputStream

class SvgVisualizationWriter(entities: List<Entity>, relationships: List<Relationship>) :
    VisualizationWriter(entities, relationships) {
    private val logger = KotlinLogging.logger {}

    override fun generate(): String {
        logger.debug { "Generating SVG..." }

        val dot = DotVisualizationWriter(entities, relationships).generate()
        val svg = toSvg(dot)

        logger.debug { "Generated SVG" }
        return svg
    }

    private fun toSvg(dot: String): String {
        logger.debug { "Converting DOT to SVG..." }
        val graph = guru.nidi.graphviz.parse.Parser.read(dot)

        val svg = ByteArrayOutputStream().use {
            Graphviz
                .fromGraph(graph)
                .render(Format.SVG)
                .toOutputStream(it)

            it.toString()
        }

        logger.debug { "Converted DOT to SVG" }
        logger.trace { "Converted DOT to SVG:\n$svg" }
        return svg
    }
}