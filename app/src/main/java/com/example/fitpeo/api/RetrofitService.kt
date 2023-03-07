package com.example.fitpeo.api

import com.example.fitpeo.model.photos
import com.example.fitpeo.model.photosItem
import com.example.fitpeo.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET(Constants.END_POINT)
    suspend fun getPhotos(): Response<photos>
}