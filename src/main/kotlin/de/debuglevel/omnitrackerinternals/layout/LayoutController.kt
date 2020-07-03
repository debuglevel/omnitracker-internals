package de.debuglevel.omnitrackerinternals.layout

import de.debuglevel.omnitrackerdatabasebinding.layout.Layout
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/layouts")
@Tag(name = "layouts")
class LayoutController(
    override val entityService: LayoutService
) :
    EntityController<Layout>() {
    private val logger = KotlinLogging.logger {}

}