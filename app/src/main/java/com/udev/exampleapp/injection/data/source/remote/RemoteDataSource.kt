package com.udev.exampleapp.injection.data.source.remote

import com.udev.exampleapp.injection.scopes.AppScoped
import com.udev.exampleapp.utils.Resource
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.udev.exampleapp.injection.data.source.local.prefs.PrefsHelper
import com.udev.exampleapp.injection.data.source.remote.api.http.ImdbApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

private const val KEY_EMAIL = "email"
private const val KEY_PASSWORD = "password"
private const val KEY_DDID = "ddid"
private const val KEY_LANGUAGE = "language"

@AppScoped
class RemoteDataSource @Inject constructor(
    val api: ImdbApi,
    val prefsHelper: PrefsHelper
): BaseDataSource() {


    suspend fun getPopularMovies() = getResult { api.getMostPopularMovies(prefsHelper.token) }

    suspend fun getMovieImages(imdbId: String) = getResult { api.getMovieImages(prefsHelper.token, imdbId) }

}