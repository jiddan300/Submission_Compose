package com.example.submission_compose.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.submission_compose.api.ApiConfig
import com.example.submission_compose.api.ItemsItem
import com.example.submission_compose.api.SearchResponse
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel(){
    var listUser : List<ItemsItem> by mutableStateOf(listOf())

    fun getListUser(q : String){

        val detailClient = ApiConfig.getApiService().getListUser(q)
        detailClient.enqueue(object : retrofit2.Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if(responseBody !=null){
                        listUser = responseBody.items
                    }
                } else {
                    Log.e("Search", "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.e("Search", "onFailure: ${t.message}")
            }
        })
    }
}