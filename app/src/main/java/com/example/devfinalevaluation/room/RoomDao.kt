package com.example.devfinalevaluation.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.devfinalevaluation.model.Photos

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemes(photos: List<Photos>)

    @Query("SELECT * FROM photos")
    suspend fun getPhotos(): List<Photos>
}