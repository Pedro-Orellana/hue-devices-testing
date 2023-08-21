package com.example.huedevicestesting.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.huedevicestesting.adapters.UsersAdapter
import com.example.huedevicestesting.retrofit.TestAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestViewModel(application : Application) : AndroidViewModel(application) {

    private val testRetroFit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val testAPI = testRetroFit.create(TestAPI::class.java)


    fun getUsers(adapter : UsersAdapter) {
        viewModelScope.launch(Dispatchers.IO) {
           val listOfUsers =  testAPI.getUsers()
            withContext(Dispatchers.Main){
                adapter.setUsers(listOfUsers)
            }
        }
    }
}