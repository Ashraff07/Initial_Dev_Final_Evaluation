package com.example.devfinalevaluation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.devfinalevaluation.model.Photos
import com.example.devfinalevaluation.repository.HomeActivityRepository

class HomeViewModel : ViewModel() {

    var photoLiveData: MutableLiveData<List<Photos>>?= null

    private var homeRepository: HomeActivityRepository?= null
    private val photoList = ArrayList<Photos>()
    fun setHomeRepository(homeRepository: HomeActivityRepository){
        this.homeRepository = homeRepository
    }

    fun getServicesAPICall(): MutableLiveData<List<Photos>>? {
        photoLiveData = homeRepository?.getServicesAPICall()
        return photoLiveData
    }




}