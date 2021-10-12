package com.example.bank_service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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


        val retrofit = Retrofit.Builder() // 레트로핏 연결
            .baseUrl("http://34.64.251.169:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        val userId = editRegisterId.text.toString() // 회원가입 객체들
        val userPw = editRegisterPw.text.toString()
        val userPN = editRegisterPN.text.toString()
        val userName = editRegisterName.text.toString()
        val userBirth = editRegisterBirth.text.toString()

        val btnRegisterConnfirmed:Button = findViewById(R.id.btn_register_confirmed) // 회원가입 확인 버튼

        btnRegisterConnfirmed.setOnClickListener{
            service.register(Register(userId,userPw,userPN,userName,userBirth)).enqueue(object : Callback<Any?> {
                override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                    val code = response.code()
                    if(response.isSuccessful){
                        val messege = response.body().toString()
                        Toast.makeText(this@RegisterActivity,"회원가입 성공",Toast.LENGTH_SHORT).show()
                    }
                    else if(code == 403) {
                        val messege = response.body().toString()
                        Toast.makeText(this@RegisterActivity,"중복된 계정이 존재 합니다",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Any?>, t: Throwable) {
                    Log.d("retrofitt", "통신 실패 ${t.message}")
                }
            })
        }

    }
}