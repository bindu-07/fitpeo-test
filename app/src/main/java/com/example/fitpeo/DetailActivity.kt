package com.example.fitpeo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fitpeo.databinding.ActivityDetailBinding
import com.example.fitpeo.model.photosItem
import com.example.fitpeo.viewmodel.MainViewModel
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photos = intent.getParcelableExtra<photosItem>("photos")
        if(photos != null){
            val title = binding.textview
            val image = binding.imageView

            title.text = photos.title
            Picasso.get()
                .load(photos.url)
                .into(image)
        }
    }
}