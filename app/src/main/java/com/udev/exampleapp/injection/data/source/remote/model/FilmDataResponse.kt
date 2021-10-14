package com.udev.exampleapp.injection.data.source.remote.model

import com.google.gson.annotations.SerializedName


data class FilmDataResponse(
    @SerializedName("items") val items: List<FilmDataDetails>,
    @SerializedName("errorMessage") val errorMessage: String?
)
