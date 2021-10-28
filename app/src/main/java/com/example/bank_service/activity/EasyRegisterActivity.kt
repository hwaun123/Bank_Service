package com.example.bank_service.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.bank_service.AuthInterceptor
import com.example.bank_service.R
import com.example.bank_service.RetrofitService
import com.example.bank_service.data_class.Key
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

        val okHttpClient = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://34.64.165.105:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val service = retrofit.create(RetrofitService::class.java)

        easyRegisterConfirm.setOnClickListener{
            var easyRegisterPw: String = editEasyRegister.text.toString()
            service.easyRegister(Key(easyRegisterPw)).enqueue(object : Callback<Any?> {
                override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                    Log.d("EasyRegisterRetrofit","code = ${response.code()}")
                    Log.d("EasyRegisterRetrofit","data = ${response.body()}")
                    Log.d("EasyRegisterRetrofit","pw" + easyRegisterPw)
                    if(response.isSuccessful){

                    }
                }

                override fun onFailure(call: Call<Any?>, t: Throwable) {
                    Log.d("EasyRegisterRetrofit","false")
                }
            })


        }
    }
}