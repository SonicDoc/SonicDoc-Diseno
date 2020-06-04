package com.example.sonicdocv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnIngresar.setOnClickListener {
            //debuggin
            gotoMain()

            validateLogin()
        }
    }

    private fun validateLogin() {
        TODO("Not yet implemented")
    }

    private fun gotoMain() {
        val intentMain = Intent(this, MainActivity::class.java)
        startActivity(intentMain)
        finish()
    }
}
