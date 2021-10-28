package com.example.bank_service.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bank_service.AuthIntercepter
import com.example.bank_service.R
import com.example.bank_service.RetrofitService
import com.example.bank_service.data_class.Userinfor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EasyRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_register)

        val easyRegisterBack: ImageView = findViewById(R.id.iv_easy_register_back)
        easyRegisterBack.setOnClickListener { finish() }

        val easyRegisterConfirm: Button = findViewById(R.id.btn_easy_register_confirm)
        val editEasyRegister: EditText = findViewById(R.id.edit_easyregister)

        val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthIntercepter()).build()

        val retrofit = Retrofit.Builder() // 레트로핏 연결
            .client(okHttpClient)
            .baseUrl("http://34.64.165.105:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RetrofitService::class.java)

        easyRegisterConfirm.setOnClickListener{
            var easyRegisterPw: String = editEasyRegister.text.toString()
            var key = easyRegisterPw
            service.easyRegister(key).enqueue(object : Callback<Userinfor?> {
                override fun onResponse(call: Call<Userinfor?>, response: Response<Userinfor?>) {
                    Log.d("easyRegisterRetrofit","code = ${response.code()}")
                    if(response.isSuccessful) {
                        Toast.makeText(this@EasyRegisterActivity,"간편 인증 로그인 설정 완료!",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Userinfor?>, t: Throwable) {
                    Log.d("LoginRetrofit","연결 실패")
                }
            })

            finish()
        }
    }
}