package com.udev.exampleapp.injection.data.source.remote.api.http

import com.udev.exampleapp.injection.data.source.remote.model.FilmDataResponse
import com.udev.exampleapp.injection.data.source.remote.model.FilmImagesData
import retrofit2.Response
import retrofit2.http.*


interface ImdbApi {


    @GET("API/MostPopularMovies/{apiKey}")
    suspend fun getMostPopularMovies(@Path("apiKey") apiKey: String): Response<FilmDataResponse>

    @GET("API/Images/{apiKey}/{imdbId}/short")
    suspend fun getMovieImages(@Path("apiKey") apiKey: String, @Path("imdbId") imdbId: String): Response<FilmImagesData>

}