package com.udev.exampleapp.injection.data.mapper

import com.udev.exampleapp.injection.data.model.Movie
import com.udev.exampleapp.injection.data.source.local.model.MovieDB
import com.udev.exampleapp.injection.data.source.remote.model.FilmDataDetails

object MovieMapper {
    fun toLocalMovie(movie: FilmDataDetails): MovieDB = MovieDB(
        movie.id,
        movie.rank,
        movie.rankUpDown,
        movie.title,
        movie.fullTitle,
        movie.year,
        movie.image,
        movie.crew,
        movie.IMDbRating,
        movie.IMDbRatingCount,
        false
    )

    fun toLocalMovie(movie: Movie): MovieDB = MovieDB(
        movie.id,
        movie.rank,
        movie.rankUpDown,
        movie.title,
        movie.fullTitle,
        movie.year,
        movie.image,
        movie.crew,
        movie.IMDbRating,
        movie.IMDbRatingCount,
        movie.watched
    )

    fun fromLocalMovie(movie: MovieDB): Movie = Movie(
        movie.id,
        movie.rank,
        movie.rankUpDown,
        movie.title,
        movie.fullTitle,
        movie.year,
        movie.image,
        movie.crew,
        movie.IMDbRating,
        movie.IMDbRatingCount,
        movie.watched
    )
}

