package com.example.sonicdocv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sonicdocv2.models.LoginResponse
import com.example.sonicdocv2.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUsername.setText("43114343")
        etPassword.setText("1234")
        btnIngresar.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if(username.isEmpty()){
                etUsername.error = "el usuario es requerido"
                etUsername.requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                etPassword.error = "la contraseña es requerida"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.userLogin(username,password).enqueue(object:
                retrofit2.Callback<LoginResponse>
            {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if(!response.body()?.Error!!){
                        var msgLogin:String?
                        msgLogin= response.body()?.Mensaje!!
                        goToMain(msgLogin)
                    }else{
                        textMessaje.text = response.body()?.Mensaje!!
                    }

                }
            })
        }
        btnSkip.setOnClickListener{
            goToMain("No Registrado")
        }
    }
    fun goToMain(msgLogin:String){
        val intent:Intent= Intent(this@LoginActivity, MainActivity::class.java)
        intent.putExtra("username", msgLogin)
        startActivity(intent)
    }
}
