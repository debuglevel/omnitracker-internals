package de.debuglevel.omnitrackerinternals.diagram

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Attribute
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Cardinality
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship

class ErWriter(entities: List<Entity>, relationships: List<Relationship>) :
    VisualizationWriter(entities, relationships) {
    override fun generate(): String {
        var output = ""
        output += entities.map { generate(it) }.joinToString(separator = "\n\n")
        output += "\n\n"
        output += relationships.map { generate(it) }.joinToString(separator = "\n")

        return output
    }

    fun generate(entity: Entity): String {
        var output = ""
        output += "[${entity.name}]"
        output += " {bgcolor: \"${entity.color}\"}\n"
        output += entity.attributes.map { generate(it) }.joinToString(separator = "\n")

        return output
    }

    fun generate(attribute: Attribute): String {
        var output = ""
        output += if (attribute.foreignKey) "+" else ""
        output += if (attribute.primaryKey) "*" else ""
        output += attribute.name
        output += if (attribute.label != null) " {label: \"${attribute.label}\"}" else ""

        return output
    }

    fun generate(relationship: Relationship): String {
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