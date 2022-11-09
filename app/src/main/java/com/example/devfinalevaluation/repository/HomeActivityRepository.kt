package com.example.devfinalevaluation.repository

import androidx.lifecycle.MutableLiveData
import com.example.devfinalevaluation.model.Photos
import com.example.devfinalevaluation.retrofit.ApiInterface
import com.example.devfinalevaluation.retrofit.RetrofitClient
import kotlinx.coroutines.*

class HomeActivityRepository() {
    private var photoLiveData = MutableLiveData<List<Photos>>()
    val errorMessage = MutableLiveData<String>()
    var job: Job? = null

    val exceptionHandler = CoroutineExceptionHandler{_,
                                                     throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }


    fun getServicesAPICall() : MutableLiveData<List<Photos>> {
        job = CoroutineScope(
            Dispatchers.IO +
                    exceptionHandler
        ).launch {
            val response = RetrofitClient.getInstance().create(ApiInterface::class.java)
            val res = response.getServicesAPICall()
            withContext(Dispatchers.Main) {
                if (res.isSuccessful) {

                    photoLiveData.postValue(res.body())

                }else{
                    onError("Error : ${res.message()}")
                }
            }

        }
        return photoLiveData
    }
    private fun onError(message: String) {
        errorMessage.value = message
    }



}