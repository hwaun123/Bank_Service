package com.example.bank_service

data class ReceiveObject(
    var idx: Int? = 0,
    var senderId: String? = null,
    var accountId: String? = null,
    var account: String? = null,
    var money: Int? = 0,
    var createAt: String? = null
)