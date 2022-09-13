package com.deloitte.retrofitdemo.retrofit

import com.deloitte.retrofitdemo.model.Album
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

  @GET("albums")
  fun getAlbums(): Call<List<Album>>

}

