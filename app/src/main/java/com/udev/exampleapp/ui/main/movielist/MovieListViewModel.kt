package com.udev.exampleapp.ui.main.movielist

import androidx.lifecycle.LiveData
import com.udev.exampleapp.injection.data.model.Movie
import com.udev.exampleapp.injection.data.repository.MovieRepository
import com.udev.exampleapp.ui.BaseViewModel
import com.udev.exampleapp.utils.Resource
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    val movieRepository: MovieRepository
): BaseViewModel() {


    val movieList: LiveData<Resource<List<Movie>>>
        get() = loadMovieList()

    fun loadMovieList(): LiveData<Resource<List<Movie>>> {
        return movieRepository.getMovieList()
    }

    fun updateMovie(movie: Movie) {
        movieRepository.updateMovie(movie)
    }
}