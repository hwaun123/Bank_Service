package com.example.bank_service

import com.example.bank_service.data_class.Login
import com.example.bank_service.data_class.Register
import com.example.bank_service.data_class.Userinfor
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("auth/register")
    fun register(
        @Body register: Register
    ): Call<Any?>

    @POST("auth/login")
    fun login(
        @Body login: Login
    ): Call<Userinfor?>

    @POST("auth/easy/register")
    fun easyRegister(
        @Body
        key: String
    ): Call<Userinfor?>
}