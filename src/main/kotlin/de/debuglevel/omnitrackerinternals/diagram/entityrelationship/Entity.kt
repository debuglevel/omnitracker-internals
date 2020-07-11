package de.debuglevel.omnitrackerinternals.diagram.entityrelationship

import de.debuglevel.omnitrackerdatabasebinding.folder.Folder

data class Entity(
    val name: String,
    val folder: Folder,
    val attributes: List<Attribute>
) {

    /**
     * Generates a pseudorandom hexadecimal color (e.g. #123456).
     * Hashcode of the entity is used as seed and therefore reproducible.
     */
    val hexcolor: String
        get() {
            // use a minimum value to avoid dark colors
            val minimumValue = 155

            val red = generateColorByte(1, minimumValue)
            val blue = generateColorByte(2, minimumValue)
            val green = generateColorByte(3, minimumValue)

            val hexcolor = String.format("#%02X%02X%02X", red, green, blue)

            return hexcolor
        }

    private fun generateColorByte(seed: Long, minimumValue: Int): Byte {
        val colorRange = (minimumValue..255)
        val randomColorValue = colorRange.random(name.hashCode().toLong() + seed)
        return randomColorValue.toByte()
    }
}
