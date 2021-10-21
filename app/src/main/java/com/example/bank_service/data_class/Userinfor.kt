package com.example.bank_service.data_class

import java.io.Serializable

class Userinfor(
    var status: String? = null,
    var message: String? = null,
    var data: Data? = null
) : Serializable
