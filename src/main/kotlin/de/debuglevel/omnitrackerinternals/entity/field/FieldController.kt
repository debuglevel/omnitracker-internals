package de.debuglevel.omnitrackerinternals.entity.field

import de.debuglevel.omnitrackerdatabasebinding.field.Field
import de.debuglevel.omnitrackerinternals.entity.EntityController
import io.micronaut.http.annotation.Controller
import io.swagger.v3.oas.annotations.tags.Tag
import mu.KotlinLogging

@Controller("/fields")
@Tag(name = "fields")
class FieldController(
    override val entityService: FieldService
) :
    EntityController<Field>() {
    private val logger = KotlinLogging.logger {}

}