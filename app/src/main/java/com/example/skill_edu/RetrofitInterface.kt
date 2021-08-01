package com.example.skill_edu

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("api/{path}")
    fun getUsers(
        @Path("path")path: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Single<UsersData>
}