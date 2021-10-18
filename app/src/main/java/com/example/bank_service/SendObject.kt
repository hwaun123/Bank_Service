package com.example.bank_service

data class SendObject(
    var idx: Int? = 0,
    var reciverId: String? = null,
    var accountId: String? = null,
    var account: String? = null,
    var money: Int = 0,
    var createdAt: String? = null
)