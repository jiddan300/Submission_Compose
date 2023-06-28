package com.example.submission_compose.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.submission_compose.api.ApiConfig
import com.example.submission_compose.api.DetailUserResponse
import retrofit2.Call
import retrofit2.Response

class DetailViewModel : ViewModel() {

    var avatarUser : String by mutableStateOf("")
    var namaUser : String by mutableStateOf("")
    var idUser : String by mutableStateOf("")


    fun getDetailUser(username:String){
        val detailClient = ApiConfig.getApiService().getDetailUser(username)
        detailClient.enqueue(object : retrofit2.Callback<DetailUserResponse> {
            override fun onResponse(call: Call<DetailUserResponse>, response: Response<DetailUserResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if(responseBody !=null){
                        avatarUser = responseBody.avatarUrl.ifEmpty { "" }
                        namaUser = responseBody.name.ifEmpty { "" }
                        idUser = responseBody.id.toString().ifEmpty { "" }
                    }
                } else {
                    Log.e("Search", "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                Log.e("Search", "onFailure: ${t.message}")
            }
        })
    }
}

