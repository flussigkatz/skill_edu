package com.example.skill_edu


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("support")
    val support: Support
)