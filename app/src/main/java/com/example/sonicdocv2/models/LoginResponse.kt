package com.example.sonicdocv2.models

data class LoginResponse (
    val ID:Int,
    val Estado:Int,
    val Error: Boolean,
    val Mensaje:String?
)