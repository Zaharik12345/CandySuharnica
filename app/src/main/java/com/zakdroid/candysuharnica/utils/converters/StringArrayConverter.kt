package com.zakdroid.candysuharnica.utils.converters

import androidx.room.TypeConverter
import java.util.stream.Collectors

class StringArrayConverter {

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.stream().collect(Collectors.joining(",!"))
    }

    @TypeConverter
    fun toList(data: String): List<String> {
        return data.split(",!")
    }
}