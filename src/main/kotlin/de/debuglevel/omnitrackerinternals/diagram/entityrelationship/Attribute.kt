package de.debuglevel.omnitrackerinternals.diagram.entityrelationship

import de.debuglevel.omnitrackerdatabasebinding.field.Field

data class Attribute(
    val name: String,
    val field: Field,
    val primaryKey: Boolean,
    val foreignKey: Boolean,
    val label: String? = null
)