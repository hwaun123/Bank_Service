package com.example.bank_service

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText

class LoginDialog(context: Context)
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

        val btnLoginConfirm: Button = dialog.findViewById(R.id.btn_login_confirm)
        btnLoginConfirm.setOnClickListener{
            val id = dialog.findViewById<EditText>(R.id.edit_login_id).text.toString()
            val pw = dialog.findViewById<EditText>(R.id.edit_login_pw).text.toString()


        }

    }

    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }

}