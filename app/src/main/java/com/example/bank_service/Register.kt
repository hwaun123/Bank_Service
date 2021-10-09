package com.example.bank_service

import java.io.Serializable

class Register(
    var userId:String,
    var userPw:String,
    var userPhone:String,
    var userName:String,
    var userBirth:String
) : Serializable
