package com.example.bank_service

data class Data(
    var user: User? = null,
    var token: String? = null,
    var refreshToken: String? = null
)