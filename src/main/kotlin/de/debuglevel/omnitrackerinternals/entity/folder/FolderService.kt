package de.debuglevel.omnitrackerinternals.entity.folder

import de.debuglevel.omnitrackerdatabasebinding.folder.Folder
import de.debuglevel.omnitrackerinternals.entity.EntityService
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class FolderService(
    override val entityService: de.debuglevel.omnitrackerdatabasebinding.folder.FolderService
) : EntityService<Folder>() {
    private val logger = KotlinLogging.logger {}
}