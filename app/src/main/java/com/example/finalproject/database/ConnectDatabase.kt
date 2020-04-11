package com.example.finalproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.*
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.finalproject.Helper.DataConverter

@Database(entities = arrayOf(User::class), version = 1,exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class ConnectDatabase:RoomDatabase(){

    abstract fun userDAO(): UserDAO //abtract fun
    companion object{
        private const val DATABASE_NAME = "beers.db"
        @Volatile
        private var INSTANCE : ConnectDatabase? = null

       fun getInstance(context: Context) :ConnectDatabase?{
           INSTANCE?: synchronized(this){
               //bloquear db para asegurar solo una co
               INSTANCE= Room.databaseBuilder(
                   context.applicationContext,
                   ConnectDatabase::class.java,
                   DATABASE_NAME
               //el context va relacionado con las actividades
               ).build()
           }
           return INSTANCE
       }

    }
}