package com.udev.exampleapp.injection.data.repository

import com.udev.exampleapp.injection.data.model.Movie
import com.udev.exampleapp.injection.data.source.local.MovieLocalDataSource
import com.udev.exampleapp.injection.data.source.remote.RemoteDataSource
import com.udev.exampleapp.injection.network.NetManager
import com.udev.exampleapp.utils.performGetOperation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MovieRepository(
    val remote: RemoteDataSource,
    val local: MovieLocalDataSource,
    val netManager: NetManager
) {

    fun getMovieList()= performGetOperation(
        databaseQuery = {local.getMovies()},
        networkCall = { remote.getPopularMovies()},
        saveCallResult = { local.insert(it.items)}
    )

    suspend fun getMovieImages(imdbId: String) = remote.getMovieImages(imdbId)

    fun updateMovie(movie: Movie) {
        GlobalScope.launch(Dispatchers.IO) { local.updateMove(movie) }
    }

}