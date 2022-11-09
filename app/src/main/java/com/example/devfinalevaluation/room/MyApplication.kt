package com.example.devfinalevaluation.room

import android.app.Application
import com.example.devfinalevaluation.repository.HomeActivityRepository

class MyApplication:Application() {

    lateinit var homeActivityRepository: HomeActivityRepository

    override fun onCreate() {
        super.onCreate()

        val database = PhotoDatabase.getDataBase(applicationContext)
        homeActivityRepository = HomeActivityRepository(database)
    }
}