package com.example.devfinalevaluation.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.devfinalevaluation.model.Photos
import com.example.devfinalevaluation.retrofit.ApiInterface
import com.example.devfinalevaluation.retrofit.RetrofitClient
import com.example.devfinalevaluation.room.PhotoDatabase
import com.example.devfinalevaluation.utils.NetworkUtils
import kotlinx.coroutines.*

class HomeActivityRepository(
    private val photoDatabase: PhotoDatabase,
    private val applicationContext: Context
) {
    private var photoLiveData = MutableLiveData<List<Photos>>()
    val errorMessage = MutableLiveData<String>()
    var job: Job? = null

    val exceptionHandler = CoroutineExceptionHandler { _,
                                                       throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }


    fun getServicesAPICall(): MutableLiveData<List<Photos>> {
        job = CoroutineScope(
            Dispatchers.IO +
                    exceptionHandler
        ).launch {
            val response = RetrofitClient.getInstance().create(ApiInterface::class.java)
            val res = response.getServicesAPICall()
            withContext(Dispatchers.Main) {

                if (NetworkUtils.isInternetAvailable(applicationContext)) {
                    if (res.isSuccessful) {

                        photoDatabase.photoDao().insertMemes(res.body()!!)
                        photoLiveData.postValue(res.body())

                    } else {
                        onError("Error : ${res.message()}")
                    }
                } else {
                    val photos = photoDatabase.photoDao().getPhotos()
                    photoLiveData.postValue(photos)
                }
            }

        }
        return photoLiveData
    }

    private fun onError(message: String) {
        errorMessage.postValue(message)
    }


}