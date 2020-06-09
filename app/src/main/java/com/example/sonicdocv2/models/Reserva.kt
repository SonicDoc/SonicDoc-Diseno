package com.example.sonicdocv2.models

import com.google.gson.annotations.SerializedName

class Reserva (
    @SerializedName("ID")
    val ID:Int,
    @SerializedName("Nombre")
    val Nombre:String,
    @SerializedName("Fecha")
    val Fecha:String,
    @SerializedName("Turno")
    val Turno:String,
    @SerializedName("Sexo")
    val Sexo:Int,
    @SerializedName("Estado")
    val Estado:Int
)