package com.example.bank_service.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.bank_service.R

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        val loginDialog: LoginDialog

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvRegister: TextView = findViewById(R.id.tv_register)
        tvRegister.setOnClickListener{
            val registerIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(registerIntent)
        }

        val btnLogin:Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener{
            val dialog = LoginDialog(this)
            dialog.showDialog()

        }
        

    }

}