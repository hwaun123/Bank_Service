package com.example.bank_service

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bank_service.data_class.Login
import com.example.bank_service.data_class.Userinfor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginDialog(private val context: Context)
{
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.login_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        val retrofit = Retrofit.Builder() // 레트로핏 연결
            .baseUrl("http://34.64.165.105:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        val btnLoginConfirm: Button = dialog.findViewById(R.id.btn_login_confirm)
        btnLoginConfirm.setOnClickListener{
            val id = dialog.findViewById<EditText>(R.id.edit_login_id).text.toString()
            val pw = dialog.findViewById<EditText>(R.id.edit_login_pw).text.toString()

            service.login(Login(id,pw)).enqueue(object : Callback<Userinfor?>{
                override fun onResponse(call: Call<Userinfor?>, response: Response<Userinfor?>) {
                    val code = response.code()
                    Log.d("LoginRetrofit","code = $code")
                    Log.d("LoginResponsee","data = ${response.body()}")
                    if(code == 200) {
                        Toast.makeText(context,"로그인 성공!",Toast.LENGTH_SHORT).show()
                        val intent = Intent(context,MainActivity::class.java)
                        context.startActivity(intent)
                    }
                    else if (code == 401){
                        Toast.makeText(context,"아이디나 비밀번호를 다시 확인해 주세요",Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<Userinfor?>, t: Throwable) {
                    Log.d("LoginRetrofit","연결 실패")
                }


            })
        }

    }

    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }

}