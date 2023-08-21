package com.example.huedevicestesting.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.huedevicestesting.adapters.UsersAdapter
import com.example.huedevicestesting.retrofit.TestAPI
import com.example.huedevicestesting.retrofit.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    fun getUsersWithNoCoroutines(adapter : UsersAdapter) {
        val apiCall = testAPI.getUsersWithoutCoroutines()
        apiCall.enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.body() != null) {
                    adapter.setUsers(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    fun getUsersSynchronously(adapter : UsersAdapter) {
        val response = testAPI.getUsersWithoutCoroutines().execute()
        if(response.body() != null){
            adapter.setUsers(response.body()!!)
        }
    }
}


