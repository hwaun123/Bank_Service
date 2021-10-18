package com.example.bank_service

data class AccountObject(
    var accountId: String? = null,
    var money: Int? = 0,
    var password: String? = null,
    var userPhone: String? = null,
    var user: String? = null,
    var receive: Receive? = null,
    var send: Send? = null
)