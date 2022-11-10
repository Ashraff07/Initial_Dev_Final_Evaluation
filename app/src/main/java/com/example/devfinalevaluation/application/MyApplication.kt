package com.example.devfinalevaluation.application

import android.app.Application
import com.example.devfinalevaluation.repository.HomeActivityRepository
import com.example.devfinalevaluation.room.PhotoDatabase

class MyApplication : Application() {

    lateinit var homeActivityRepository: HomeActivityRepository

    override fun onCreate() {
        super.onCreate()

        val database = PhotoDatabase.getDataBase(applicationContext)
        homeActivityRepository = HomeActivityRepository(database, applicationContext)
    }
}