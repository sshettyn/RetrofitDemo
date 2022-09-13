package com.deloitte.retrofitdemo.repository

import androidx.lifecycle.MutableLiveData
import com.deloitte.retrofitdemo.model.Album
import com.deloitte.retrofitdemo.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class HomeActivityRepository {

  val albumData = MutableLiveData<List<Album>>()
  val failureData = MutableLiveData<String>()

  fun getAlbums(): MutableLiveData<List<Album>> {
    val call = RetrofitClient.apiInterface.getAlbums()

    call.enqueue(object : retrofit2.Callback<List<Album>>{
      override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
          albumData.postValue(response.body())
      }

      override fun onFailure(call: Call<List<Album>>, t: Throwable) {
          failureData.postValue("failed")
      }


    })
    return albumData
  }
}