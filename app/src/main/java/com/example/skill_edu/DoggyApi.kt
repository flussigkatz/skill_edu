package com.example.skill_edu

import retrofit2.http.GET

interface DoggyApi {
    @GET("random")
    suspend fun getRandomDog(): DoggyResponse
}