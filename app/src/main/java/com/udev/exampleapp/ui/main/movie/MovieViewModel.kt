package com.udev.exampleapp.ui.main.movie

import com.udev.exampleapp.injection.data.repository.MovieRepository
import com.udev.exampleapp.injection.data.source.remote.model.FilmImagesData
import com.udev.exampleapp.ui.BaseViewModel
import com.udev.exampleapp.utils.Resource
import com.udev.exampleapp.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    val movieRepository: MovieRepository
): BaseViewModel() {

    val movieResult = SingleLiveEvent<Resource<FilmImagesData>>()

    fun getMovieImages(imdbId: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val result = movieRepository.getMovieImages(imdbId)
            movieResult.postValue(result)
        }
    }
}