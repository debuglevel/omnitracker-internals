package de.debuglevel.omnitrackerinternals.entity.layout

import de.debuglevel.omnitrackerdatabasebinding.layout.Layout
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.server.types.files.StreamedFile
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/layouts")
@Tag(name = "layouts")
class LayoutController(
    override val entityService: LayoutService
) :
    EntityController<Layout>() {
    private val logger = KotlinLogging.logger {}

    @Get("/files/{id}")
    fun getLayoutFile(id: Int): StreamedFile {
        logger.debug("Called getLayoutFile()")

        val layout = entityService.get(id)
        val inputStream = layout!!.reportData.inputStream()
        val fileExtension = layout.outputType?.fileExtension ?: ".unknown"
        val filename = "${layout.name}.${fileExtension}"
        return StreamedFile(inputStream, MediaType.TEXT_PLAIN_TYPE).attach(filename)
    }
}