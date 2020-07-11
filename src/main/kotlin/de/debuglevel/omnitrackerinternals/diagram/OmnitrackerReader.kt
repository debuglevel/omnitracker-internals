package de.debuglevel.omnitrackerinternals.diagram

import de.debuglevel.omnitrackerdatabasebinding.field.FieldType
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Attribute
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Cardinality
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Entity
import de.debuglevel.omnitrackerinternals.diagram.entityrelationship.Relationship
import javax.inject.Singleton

@Singleton
class OmnitrackerReader(
    val folderService: de.debuglevel.omnitrackerdatabasebinding.folder.FolderService,
    val fieldService: de.debuglevel.omnitrackerdatabasebinding.field.FieldService
) : Reader {
    fun sanitize(name: String): String {
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

    //private val omnitrackerDatabase = OmnitrackerDatabase()

    private val fields = fieldService.getAll()
    private val folders = folderService.getAll()

    override val entities: List<Entity>
        get() {
            val entities =
                folders.values.map { folder ->
                    val attributes =
                        fields.values.filter { it.folderId == folder.id }
                            .map { Attribute(sanitize(it.label), it, false, false) }

                    Entity(sanitize("[${folder.id}] ${folder.name}"), folder, attributes)
                }

            return entities
        }

    override val relationships: List<Relationship>
        get() {
            val relationships = mutableListOf<Relationship>()

            for (entity in entities) {
                for (attribute in entity.attributes.filter { it.field.referenceFolderId != null }) {
                    val referencedEntity = entities.first { it.folder.id == attribute.field.referenceFolderId }

                    val cardinality = when (attribute.field.type) {
                        FieldType.ObjectReference -> Cardinality.ZeroOrOne
                        FieldType.ObjectReferenceList -> Cardinality.ZeroOrMore
                        else -> Cardinality.Unknown
                    }

                    val relationship = Relationship(entity, referencedEntity, cardinality, Cardinality.One)
                    relationships.add(relationship)
                }
            }

            return relationships
        }
}