package com.example.fitpeo.utils

class Validation {

    fun photos(text: String, url:String):Boolean{
        if (text.isEmpty() or url.isEmpty()) {
            return false
        }
        return true

    }
}