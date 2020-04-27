package ru.ok.technopolis.training.personal.utils.common

import kotlin.text.StringBuilder

object StringUtils {

    private val stringBuilder = StringBuilder()

    @JvmStatic
    fun concat(vararg strings: String): String {
        for (str in strings) {
            stringBuilder.append(str)
        }
        val result = stringBuilder.toString()
        stringBuilder.clear()
        return result
    }

    @JvmStatic
    fun concatWithSpace(vararg strings: String): String {
        for (i in strings.indices - 1) {
            stringBuilder.append(strings[i]).append(" ")
        }
        stringBuilder.append(strings[strings.size - 1])
        val result = stringBuilder.toString()
        stringBuilder.clear()
        return result
    }
}