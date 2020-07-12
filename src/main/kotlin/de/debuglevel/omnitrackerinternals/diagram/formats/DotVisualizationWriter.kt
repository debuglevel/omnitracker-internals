package de.debuglevel.omnitrackerinternals.diagram.formats

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Attribute
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship
import mu.KotlinLogging

class DotVisualizationWriter(entities: List<Entity>, relationships: List<Relationship>) :
    VisualizationWriter(entities, relationships) {
    private val logger = KotlinLogging.logger {}

    override fun generate(): String {
        logger.debug { "Generating DOT..." }

        var dot = """
            digraph graphname {
            
            node [
              shape = "record"
            ]
    
            edge [
              arrowhead = "empty"
            ]
        """.trimIndent()

        dot += entities.joinToString(separator = "\n\n") { generate(it) }
        dot += relationships.joinToString(separator = "\n") { generate(it) }

        dot += "\n}\n"

        logger.debug { "Generated DOT" }
        logger.trace { "Generated DOT: $dot" }
        return dot
    }

    private fun generate(entity: Entity): String {
        logger.debug { "Creating DOT description of entity $entity..." }

        val label = entity.name
        //+ "|"
        //+ entity.attributes.map { generate(it) }.joinToString(separator = "\\l")

        val output = "${entity.hashCode()}[label=\"$label\"];\n"
        return output
    }

    private fun generate(attribute: Attribute): String {
        logger.debug { "Creating DOT description of attribute $attribute..." }

        val output = attribute.name
        return output
    }

    private fun generate(relationship: Relationship): String {
        logger.debug { "Creating DOT description of relationship $relationship..." }

        val output = "${relationship.left.hashCode()} -> ${relationship.right.hashCode()}"
        return output

//        var output = ""
//        output += "${relationship.left.name}"
//
//        output += when (relationship.rightHasThatManyLefts) {
//            Cardinality.One -> "\"1\""
//            Cardinality.OneOrMore -> "\"1+\""
//            Cardinality.ZeroOrOne -> "\"0,1\""
//            Cardinality.ZeroOrMore -> "\"0+\""
//        }
//        output += " *-- "
//        output += when (relationship.leftHasThatManyRights) {
//            Cardinality.One -> "\"1\""
//            Cardinality.OneOrMore -> "\"1+\""
//            Cardinality.ZeroOrOne -> "\"0,1\""
//            Cardinality.ZeroOrMore -> "\"0+\""
//        }
//        output += "${relationship.right.name}"
//        output += if (relationship.label != null) " : ${relationship.label}" else ""
//
//        return output
    }
}