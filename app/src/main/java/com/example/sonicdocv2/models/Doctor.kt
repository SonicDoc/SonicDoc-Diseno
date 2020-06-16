package com.example.sonicdocv2.models

import com.google.gson.annotations.SerializedName

class Doctor (
    @SerializedName("ID")
    val ID:Int,
    @SerializedName("Nombre")
    val Nombre:String,
    @SerializedName("Especialidad")
    val Especialidad:String
)