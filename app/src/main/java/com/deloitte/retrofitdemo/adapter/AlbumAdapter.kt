package com.deloitte.retrofitdemo.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deloitte.retrofitdemo.R
import com.deloitte.retrofitdemo.model.Album

class AlbumAdapter(private val dataSet: List<Album>):
  RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

  class AlbumViewHolder(view: View): RecyclerView.ViewHolder(view){
    val title: TextView = view.findViewById(R.id.tvTitle)
    val id: TextView = view.findViewById(R.id.tvId)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
    return AlbumViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
  }

  override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
    holder.title.text = dataSet.get(position).title
    holder.id.text = dataSet.get(position).id
  }

  override fun getItemCount(): Int {
    return dataSet.size
  }
}