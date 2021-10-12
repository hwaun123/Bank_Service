package com.example.bank_service

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Register(
    @SerializedName("id")
    var id:String,
    @SerializedName("pw")
    var pw:String,
    @SerializedName("phone")
    var phone:String,
    @SerializedName("name")
    var name:String,
    @SerializedName("birth")
    var birth:String
) : Serializable
