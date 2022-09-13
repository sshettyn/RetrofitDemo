package com.deloitte.retrofitdemo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deloitte.retrofitdemo.model.Album
import com.deloitte.retrofitdemo.repository.HomeActivityRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

  lateinit var model: HomeViewModel

  @MockK
  lateinit var homeActivityRepository: HomeActivityRepository

  @get:Rule
  val rule = InstantTaskExecutorRule()


  @Before
  fun setUp() {
    MockKAnnotations.init(this, relaxUnitFun = true)

    model = HomeViewModel()
    model.setHomeRepository(homeActivityRepository)
  }

  @Test
  fun `test API call`() {
  every { homeActivityRepository.getAlbums() } returns MutableLiveData<List<Album>>().apply {
    postValue(listOf((Album(
      "dafdsf","dfdsfsd"
    ))))
  }
    model.getAlbums()
     Assert.assertEquals(model.albumLiveData?.value, listOf(Album(
       "dafdsf","dfdsfsd"
     )))
  }
}