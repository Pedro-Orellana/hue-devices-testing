package com.example.huedevicestesting.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.huedevicestesting.retrofit.BridgeResponse
import com.example.huedevicestesting.retrofit.HueDiscoveryAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HueViewModel(application : Application) : AndroidViewModel(application) {

    private val bridgeDiscoveryRetrofit = Retrofit.Builder()
        .baseUrl("https://discovery.meethue.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val hueDiscoveryAPI = bridgeDiscoveryRetrofit.create(HueDiscoveryAPI::class.java)

    fun discoverBridge () {
        viewModelScope.launch(Dispatchers.IO) {
            hueDiscoveryAPI.discoverBridge()
        }
    }

}