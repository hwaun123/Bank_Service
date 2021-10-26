package com.example.bank_service.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bank_service.R

class EasyRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_register)

        val easyRegisterBack: ImageView = findViewById(R.id.iv_easy_register_back)
        easyRegisterBack.setOnClickListener { finish() }

        val easyRegisterConfirm: Button = findViewById(R.id.btn_easy_register_confirm)
        val editEasyRegister: EditText = findViewById(R.id.edit_easyregister)
        easyRegisterConfirm.setOnClickListener{
            var easyRegisterPw: String = editEasyRegister.text.toString()
            Toast.makeText(this,easyRegisterPw,Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}