package com.kampusmerdeka.retrofit.Api

import com.kampusmerdeka.retrofit.ResponseRick
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getRick() : Call<ResponseRick>
}