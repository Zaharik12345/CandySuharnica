package com.zakdroid.candysuharnica.utils.converters

import androidx.room.TypeConverter
import java.util.stream.Collectors

class IntArrayConverter {

    @TypeConverter
    fun fromList(list: List<Int>): String {
        return list.map { it.toString() }
            .stream().collect(Collectors.joining(",!"))
    }

    @TypeConverter
    fun toList(data: String): List<Int> {
        return data.split(",!").map { it.toInt() }
    }
}