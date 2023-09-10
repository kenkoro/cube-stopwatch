package com.kenkoro.stopwatch.model

import kotlin.random.Random

class ScramblerBuilder {
    companion object {
        private const val from = 12
        private const val until = 20

        fun generate(): String {
            var result = ""
            val directions = "UDRLFB"
            val extra = "'2"
            var lastLetter = ""
            for (times in 1..Random.nextInt(from, until)) {
                val directionsWithoutRepetitions = directions.replace(lastLetter, "", true)
                lastLetter =
                    directionsWithoutRepetitions[Random.nextInt(
                        directionsWithoutRepetitions.length
                    )].toString()
                result += lastLetter
                result += if (Random.nextBoolean()) {
                    extra[Random.nextInt(2)]
                } else ""
                result += " "
            }

            return result
        }
    }

}