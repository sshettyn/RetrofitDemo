package com.deloitte.retrofitdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deloitte.retrofitdemo.model.Album
import com.deloitte.retrofitdemo.repository.HomeActivityRepository

class HomeViewModel: ViewModel() {

  var albumLiveData: MutableLiveData<List<Album>>? = null
  var homeActivityRepository:HomeActivityRepository? = null

  fun setHomeRepository(homeActivityRepository:HomeActivityRepository){
     this.homeActivityRepository = homeActivityRepository
  }

  fun getAlbums(): LiveData<List<Album>>{
    albumLiveData = homeActivityRepository?.getAlbums()
    return albumLiveData as MutableLiveData<List<Album>>
  }

  fun getFailure(): LiveData<String>?{
    return homeActivityRepository?.failureData
  }
}