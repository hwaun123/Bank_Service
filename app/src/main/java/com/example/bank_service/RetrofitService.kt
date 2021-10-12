package com.example.bank_service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("auth/register")
    fun register(
        @Body register: Register
    ): Call<Any?>

}