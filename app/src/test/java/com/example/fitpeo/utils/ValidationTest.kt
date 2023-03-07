package com.example.fitpeo.utils

import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class ValidationTest {

    private lateinit var validation: Validation
    @Before
    fun setUp(){
        validation = Validation()
    }

    @Test
    fun checkPhotos(){
        val result = validation.photos("I am good", "https://jsonplaceholder.typicode.com/photos")
        assertThat(result).isTrue()
    }
}