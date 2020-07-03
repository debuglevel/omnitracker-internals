package de.debuglevel.omnitrackerinternals.folder

import de.debuglevel.omnitrackerdatabasebinding.folder.Folder
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/folders")
@Tag(name = "folders")
class FolderController(
    override val entityService: FolderService
) :
    EntityController<Folder>() {
    private val logger = KotlinLogging.logger {}

}