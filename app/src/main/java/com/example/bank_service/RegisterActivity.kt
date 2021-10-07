package com.example.bank_service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val ivBack:ImageView = findViewById(R.id.iv_register_back)

        ivBack.setOnClickListener {
            finish()
        }
    }
}