package com.example.fitpeo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitpeo.databinding.PhotosLayoutBinding
import com.example.fitpeo.model.photosItem
import com.squareup.picasso.Picasso

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: PhotosLayoutBinding):
        RecyclerView.ViewHolder(binding.root)
    private val diffCallback = object : DiffUtil.ItemCallback<photosItem>(){
        override fun areItemsTheSame(oldItem: photosItem, newItem: photosItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: photosItem, newItem: photosItem): Boolean {
            return newItem == oldItem
        }

    }
    var onItemClick : ((photosItem) -> Unit)? = null

    private val differ = AsyncListDiffer(this, diffCallback)
    var photos: List<photosItem>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(PhotosLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPhotos = photos[position]
        holder.binding.apply {
            textview.text = currentPhotos.title
            Picasso.get()
                .load(currentPhotos.url)
                .into(imageView)

        }
        holder.itemView.rootView.setOnClickListener {
            onItemClick?.invoke(currentPhotos)
        }

    }


    override fun getItemCount() = photos.size
}