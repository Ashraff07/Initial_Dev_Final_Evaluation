package com.example.devfinalevaluation.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "photos")
@Parcelize
data class Photos(

    @PrimaryKey
    val id:String,
    val title:String,
    val url:String,
    val thumbnailUrl:String
):Parcelable