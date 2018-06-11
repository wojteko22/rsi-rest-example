package com.example.rest.jpa

import java.util.*
import kotlin.streams.asSequence

object RandomGenerator {

    fun randomName(minLength: Int, maxLength: Int): String {
        val nameSize = randomInt(minLength, maxLength).toLong()
        return randomName(nameSize)
    }

    fun randomInt(min: Int, maxInclusive: Int) = min + Random().nextInt(maxInclusive - min + 1)

    fun randomFloat(min: Int, maxExclusive: Int) = min + Random().nextFloat() * (maxExclusive - min)

    private fun randomName(size: Long): String {
        val source = "abcdefghijklmnoprstuwyz"
        return Random().ints(size, 0, source.length)
            .asSequence()
            .map(source::get)
            .joinToString("")
            .capitalize()
    }
}
