package com.example.bank_service.data_class

import com.google.gson.annotations.SerializedName

class Login(
    @SerializedName("id")
    val id: String?,
    @SerializedName("pw")
    val pw: String?
)