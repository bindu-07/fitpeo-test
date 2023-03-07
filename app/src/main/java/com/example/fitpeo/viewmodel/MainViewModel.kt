package com.example.fitpeo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitpeo.model.photosItem
import com.example.fitpeo.repository.PhotosRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repository: PhotosRepository) : ViewModel() {

    private val photosLiveData = MutableLiveData<List<photosItem>>()
    val photos:  LiveData<List<photosItem>>
    get() = photosLiveData

    init {
        getAllPhotos()

    }

    private fun getAllPhotos() = viewModelScope.launch {
        repository.getPhotos().let { response ->
            if (response.isSuccessful) {
                photosLiveData.postValue(response.body())
            }else{
                Log.d("tag", "getAllPhotos Error: ${response.code()}")
            }
        }
    }

}