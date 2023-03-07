package com.example.fitpeo.repository

import com.example.fitpeo.api.RetrofitService
import javax.inject.Inject

class PhotosRepository
@Inject
constructor(private val retrofitService: RetrofitService){
    suspend fun getPhotos() = retrofitService.getPhotos()

//    private val photosLiveData = MutableLiveData<photosItem>()
//    val photos:  LiveData<photosItem>
//    get() = photosLiveData
//
//
//    suspend fun getPhotos(){
//        val result = retrofitService.getPhotos()
//        if (result?.body() != null){
//            photosLiveData.postValue(result.body())
//        }
//    }

}