package com.example.bank_service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val ivBack:ImageView = findViewById(R.id.iv_register_back)
        ivBack.setOnClickListener {
            finish()
        }


        val editRegisterId: EditText = findViewById(R.id.edit_register_id)
        val editRegisterPw: EditText = findViewById(R.id.edit_register_pw)
        val editRegisterPN: EditText = findViewById(R.id.edit_register_phonenum)
        val editRegisterName: EditText = findViewById(R.id.edit_register_name)
        val editRegisterBirth: EditText = findViewById(R.id.edit_register_birth)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://34.64.251.169:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        var userId = editRegisterId.text.toString()
        var userPw = editRegisterPw.text.toString()
        var userPN = editRegisterPN.text.toString()
        var userName = editRegisterName.text.toString()
        var userBirth = editRegisterBirth.text.toString()


    }
}