package de.debuglevel.omnitrackerinternals.diagram

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import java.io.ByteArrayOutputStream

class SvgDotWriter(entities: List<Entity>, relationships: List<Relationship>) :
    VisualizationWriter(entities, relationships) {
    override fun generate(): String {
        val dot = DotWriter(entities, relationships).generate()
        println(dot)
        val svg = visualizeGraph(dot)
        return svg
    }

    private fun visualizeGraph(dot: String): String {
        val graph = guru.nidi.graphviz.parse.Parser.read(dot)

        val outputStream = ByteArrayOutputStream()

        Graphviz.fromGraph(graph)
            .render(Format.SVG)
            .toOutputStream(outputStream)
        //.toFile(File("UML.svg"))

        return outputStream.toString()
    }
}