package com.example.finalproject.Helper

import androidx.room.TypeConverter
import java.sql.Date
import java.sql.Timestamp
import java.util.logging.LogManager

class DataConverter {

    @TypeConverter
    fun toDate(timestamp: Long) : Date? {

        return if(timestamp != null) Date(timestamp) else null

    }
    @TypeConverter
    fun timeStamp(date: Date): Long? = date?.time
}