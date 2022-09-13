package com.deloitte.retrofitdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deloitte.retrofitdemo.R
import com.deloitte.retrofitdemo.adapter.AlbumAdapter
import com.deloitte.retrofitdemo.repository.HomeActivityRepository
import com.deloitte.retrofitdemo.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

  private lateinit var recyclerView: RecyclerView
  private lateinit var progressBar: ProgressBar
  private lateinit var homeViewModel: HomeViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    recyclerView = findViewById(R.id.recyclerView)
    progressBar = findViewById(R.id.progressBar)
    homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    homeViewModel.setHomeRepository(HomeActivityRepository())
    setUpList()
  }

  private fun setUpList() {
    progressBar.visibility = View.VISIBLE
    homeViewModel.getAlbums().observe(this, Observer { albums ->
      progressBar.visibility = View.GONE
      val albumAdapter = AlbumAdapter(albums)
      val layoutManager = LinearLayoutManager(applicationContext)
      recyclerView.layoutManager = layoutManager
      recyclerView.adapter = albumAdapter

    })
    homeViewModel.getFailure()?.observe(this, Observer {
        //do failure action
    })
  }

}