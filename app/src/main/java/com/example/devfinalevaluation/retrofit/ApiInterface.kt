package com.example.devfinalevaluation.retrofit

import com.example.devfinalevaluation.model.Photos
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/photos")
    suspend fun getServicesAPICall(): Response<List<Photos>>
}