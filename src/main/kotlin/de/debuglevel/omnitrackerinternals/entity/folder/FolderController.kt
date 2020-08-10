package de.debuglevel.omnitrackerinternals.entity.folder

import de.debuglevel.omnitrackerdatabasebinding.folder.Folder
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/folders")
@Tag(name = "folders")
@Secured(SecurityRule.IS_AUTHENTICATED)
class FolderController(
    override val entityService: FolderService
) :
    EntityController<Folder>() {
    private val logger = KotlinLogging.logger {}

}