package de.debuglevel.omnitrackerinternals.diagram

import de.debuglevel.omnitrackerdatabasebinding.field.FieldType
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Attribute
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Cardinality
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class OmnitrackerReader(
    private val folderService: de.debuglevel.omnitrackerdatabasebinding.folder.FolderService,
    private val fieldService: de.debuglevel.omnitrackerdatabasebinding.field.FieldService
) {
    private val logger = KotlinLogging.logger {}

    private fun sanitize(name: String): String {
        return name

        return name.replace(" ", "_")
            .replace("-", "_")
            .replace("(", "_")
            .replace(")", "_")
            .replace(",", "_")
            .replace(":", "_")
            .replace(".", "_")
            .replace("/", "_")
            .replace("\\", "_")
            .replace("&", "_")
            .replace("[", "_")
            .replace("]", "_")
            .replace("%", "_")
    }

    private val fields = fieldService.getAll()
    private val folders = folderService.getAll()

    val entities: List<Entity>
        get() {
            val entities =
                folders.values.map { folder ->
                    val attributes =
                        fields.values.filter { it.folderId == folder.id }
                            .map { Attribute(sanitize(it.label), it, primaryKey = false, foreignKey = false) }

                    Entity(sanitize("[${folder.id}] ${folder.name}"), folder, attributes)
                }

            return entities
        }

    val relationships: List<Relationship>
        get() {
            val relationships = mutableListOf<Relationship>()

            for (entity in entities) {
                for (attribute in entity.attributes.filter { it.field.referenceFolderId != null && it.field.referenceFolderId != 0 }) {
                    logger.trace { "Searching for folder with id='${attribute.field.referenceFolderId}'..." }
                    val referencedEntity =
                        entities.firstOrNull { it.folder.id == attribute.field.referenceFolderId } // CAVEAT: the sample database actually contains references to folder 0 or others which do not exist; hence firstOrNull()

                    if (referencedEntity != null) {
                        val cardinality = when (attribute.field.type) {
                            FieldType.ObjectReference -> Cardinality.ZeroOrOne
                            FieldType.ObjectReferenceList -> Cardinality.ZeroOrMore
                            else -> Cardinality.Unknown
                        }

                        val relationship = Relationship(entity, referencedEntity, cardinality, Cardinality.One)
                        relationships.add(relationship)
                    }
                }
            }

            return relationships
        }
}