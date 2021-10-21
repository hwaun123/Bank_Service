package com.example.bank_service.data_class

data class User(
    var phone: String? = null,
    var id: String? = null,
    var pw: String? = null,
    var name: String? = null,
    var birth: String? = null,
    var authentication: Authentication? = null,
    var account: Account? = null,
    var myAccount: MyAccount? = null,
)