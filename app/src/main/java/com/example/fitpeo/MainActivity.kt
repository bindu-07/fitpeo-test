package com.example.fitpeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitpeo.adapter.PhotosAdapter
import com.example.fitpeo.databinding.ActivityMainBinding
import com.example.fitpeo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setUpPhoto()

        photosAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("photos", it)
            startActivity(intent)
        }
    }

    private fun setUpPhoto() {
        photosAdapter = PhotosAdapter()

        binding.recyclerview.apply {
            adapter = photosAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true)
        }

        viewModel.photos.observe(this, {
            listphotos->
            photosAdapter.photos = listphotos
        })
    }
}