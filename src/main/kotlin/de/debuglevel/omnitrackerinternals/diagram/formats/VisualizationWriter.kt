package de.debuglevel.omnitrackerinternals.diagram.formats

import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship

abstract class VisualizationWriter(val entities: List<Entity>, val relationships: List<Relationship>) {
    abstract fun generate(): String
}