package com.example.huedevicestesting.retrofit

import retrofit2.http.GET

interface TestAPI {

    @GET("/users")
    suspend fun getUsers() : List<User>
}