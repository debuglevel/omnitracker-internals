package de.debuglevel.omnitrackerinternals.diagram.formats

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Attribute
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Cardinality
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship
import mu.KotlinLogging

class ErVisualizationWriter(entities: List<Entity>, relationships: List<Relationship>) :
    VisualizationWriter(entities, relationships) {
    private val logger = KotlinLogging.logger {}

    override fun generate(): String {
        var output = ""
        output += entities.joinToString(separator = "\n\n") { generate(it) }
        output += "\n\n"
        output += relationships.joinToString(separator = "\n") { generate(it) }

        return output
    }

    private fun generate(entity: Entity): String {
        var output = ""
        output += "[${entity.name}]"
        output += " {bgcolor: \"${entity.hexcolor}\"}\n"
        output += entity.attributes.joinToString(separator = "\n") { generate(it) }

        return output
    }

    private fun generate(attribute: Attribute): String {
        var output = ""
        output += if (attribute.foreignKey) "+" else ""
        output += if (attribute.primaryKey) "*" else ""
        output += attribute.name
        output += if (attribute.label != null) " {label: \"${attribute.label}\"}" else ""

        return output
    }

    private fun generate(relationship: Relationship): String {
        var output = ""
        output += "${relationship.left.name} "
        output += when (relationship.rightHasThatManyLefts) {
            Cardinality.One -> "1"
            Cardinality.OneOrMore -> "+"
            Cardinality.ZeroOrOne -> "?"
            Cardinality.ZeroOrMore -> "*"
            else -> "???"
        }
        output += "--"
        output += when (relationship.leftHasThatManyRights) {
            Cardinality.One -> "1"
            Cardinality.OneOrMore -> "+"
            Cardinality.ZeroOrOne -> "?"
            Cardinality.ZeroOrMore -> "*"
            else -> "???"
        }
        output += " ${relationship.right.name}"
        output += if (relationship.label != null) " {label: \"${relationship.label}\"}" else ""

        return output
    }
}