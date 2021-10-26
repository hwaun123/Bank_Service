package com.example.bank_service.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.bank_service.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgUser: ImageView = findViewById(R.id.img_user)

        imgUser.setOnClickListener {
            val intent: Intent = Intent(this, EasyRegisterActivity::class.java)
            startActivity(intent)
        }
    }
}