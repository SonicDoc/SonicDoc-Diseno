package com.example.sonicdocv2.network

import com.example.sonicdocv2.models.Reserva
import retrofit2.Call
import retrofit2.http.GET

interface ReservaService {
    @GET("Usuario/3")
    fun getAll(): Call<List<Reserva>>
}