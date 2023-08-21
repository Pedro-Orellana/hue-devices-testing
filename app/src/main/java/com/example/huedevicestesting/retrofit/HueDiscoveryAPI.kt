package com.example.huedevicestesting.retrofit

import retrofit2.http.GET

interface HueDiscoveryAPI  {
    @GET
    suspend fun discoverBridge() : BridgeResponse

}