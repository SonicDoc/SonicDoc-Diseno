package com.example.sonicdocv2.network

import com.example.sonicdocv2.models.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("Login")
    fun userLogin(
        @Field("Username") username:String,
        @Field("Password") password: String
    ): Call<LoginResponse>
}