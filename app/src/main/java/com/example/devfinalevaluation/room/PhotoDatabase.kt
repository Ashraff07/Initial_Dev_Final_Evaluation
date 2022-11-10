package com.example.devfinalevaluation.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.devfinalevaluation.model.Photos

@Database(entities = [Photos::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {

    abstract fun photoDao(): RoomDao

    companion object {
        private var INSTANCE: PhotoDatabase? = null

        fun getDataBase(context: Context): PhotoDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    PhotoDatabase::class.java,
                    "photosDB"
                ).build()
            }
            return INSTANCE!!
        }
    }
}