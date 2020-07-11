package de.debuglevel.omnitrackerinternals.diagram.entityrelationship

data class Relationship(
    val left: Entity,
    val right: Entity,
    val leftHasThatManyRights: Cardinality,
    val rightHasThatManyLefts: Cardinality,
    val label: String? = null
)