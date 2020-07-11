package de.debuglevel.omnitrackerinternals.diagram.entityrelationship

import java.util.*

/**
 * Generate a random value in between the Range
 */
fun IntRange.random(seed: Long): Int {
    val randomNumberGenerator = Random(seed)

    val lowerBoundInclusive = start
    val upperBoundInclusive = endInclusive

    // nextInt(upperExclusiveBound) returns a random value between inclusive 0 and exclusive upper bound (i.e. 0..(upper-1))
    val randomValue = randomNumberGenerator.nextInt((upperBoundInclusive + 1) - lowerBoundInclusive)

    return lowerBoundInclusive + randomValue
}