package com.example.skill_edu


import com.google.gson.annotations.SerializedName

data class UsersData(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)