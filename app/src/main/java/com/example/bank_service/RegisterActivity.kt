package com.example.bank_service

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import okhttp3.OkHttpClient
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
            .baseUrl("http://34.64.165.105:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        val btnRegisterConnfirmed:Button = findViewById(R.id.btn_register_confirmed) // 회원가입 확인 버튼

        btnRegisterConnfirmed.setOnClickListener{

            val id = editRegisterId.text.toString() // 회원가입 객체들
            val pw = editRegisterPw.text.toString()
            val phone = editRegisterPN.text.toString()
            val name = editRegisterName.text.toString()
            val birth = editRegisterBirth.text.toString()

            service.register(Register(id, pw, phone, name, birth)).enqueue(object : Callback<Any?> {
                override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                    val code = response.code()
                    Log.d("retrofitt", "통신 $code id $id pw $pw pn $phone name $name birth $birth")
                    if(response.isSuccessful){
                        Toast.makeText(this@RegisterActivity,"회원가입이 완료되었습니다",Toast.LENGTH_SHORT).show()
                        Log.d("retrofitt", "통신성공 회원가입 완료")
                        finish()
                    }
                    else if(code == 403) {
                        Toast.makeText(this@RegisterActivity,"중복된 계정입니다",Toast.LENGTH_SHORT).show()
                        Log.d("retrofitt", "통신성공 중복된 계정")
                        finish()
                    }
                }

                override fun onFailure(call: Call<Any?>, t: Throwable) {
                    Log.d("retrofitt", "통신 실패 ${t.message}")
                }
            })
        }
        

    }
}