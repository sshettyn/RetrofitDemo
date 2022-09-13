package com.deloitte.retrofitdemo.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
  const val BASE_URL = "https://jsonplaceholder.typicode.com/"

  val retrofitClient: Retrofit.Builder by lazy {

    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient.Builder()
    okHttpClient.addInterceptor(logging)

    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(okHttpClient.build())
      .addConverterFactory(GsonConverterFactory.create())
  }

  val apiInterface: ApiInterface by lazy {
    retrofitClient.build().create(ApiInterface::class.java)
  }

}