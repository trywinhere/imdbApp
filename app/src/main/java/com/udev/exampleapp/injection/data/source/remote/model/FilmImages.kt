package com.udev.exampleapp.injection.data.source.remote.model

import com.google.gson.annotations.SerializedName


data class FilmImages(
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String
)
