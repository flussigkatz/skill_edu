package com.example.skill_edu


import com.google.gson.annotations.SerializedName

data class DoggyResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)
