package com.udev.exampleapp.injection.data.model

import androidx.room.PrimaryKey

data class Movie(
    val id: String,
    val rank: String,
    val rankUpDown: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val crew: String,
    val IMDbRating: String,
    val IMDbRatingCount: String,
    var watched: Boolean
)