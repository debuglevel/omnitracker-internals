package de.debuglevel.omnitrackerinternals.diagram

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Attribute
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship


class DotWriter(entities: List<Entity>, relationships: List<Relationship>) :
    VisualizationWriter(entities, relationships) {
    override fun generate(): String {
        var s = "digraph graphname {\n"

        s += """
        node [
          shape = "record"
        ]

        edge [
          arrowhead = "empty"
        ]
        """.trimIndent()

        s += entities.map { generate(it) }.joinToString(separator = "\n\n")
        s += relationships.map { generate(it) }.joinToString(separator = "\n")

        s += "\n}\n"

        return s
    }

    fun generate(entity: Entity): String {
        var output = ""

        var label = entity.name
        //+ "|"
        //+ entity.attributes.map { generate(it) }.joinToString(separator = "\\l")

        output += "${entity.hashCode()}[label=\"$label\"];\n"

        return output
    }

    fun generate(attribute: Attribute): String {
        var output = ""

        output += "${attribute.name}"

        return output
    }

    fun generate(relationship: Relationship): String {
        var output = ""

        output = "${relationship.left.hashCode()} -> ${relationship.right.hashCode()}"

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