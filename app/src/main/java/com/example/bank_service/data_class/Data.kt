package com.example.bank_service.data_class

data class Data(
    var user: User? = null,
    var token: String? = null,
    var refreshToken: String? = null
)