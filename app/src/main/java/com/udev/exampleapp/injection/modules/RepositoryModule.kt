package com.udev.exampleapp.injection.modules

import com.udev.exampleapp.injection.data.repository.*
import com.udev.exampleapp.injection.data.source.local.*
import com.udev.exampleapp.injection.data.source.local.prefs.PrefsHelper
import com.udev.exampleapp.injection.data.source.remote.RemoteDataSource
import com.udev.exampleapp.injection.data.source.remote.api.http.ImdbApi
import com.udev.exampleapp.injection.network.NetManager
import com.udev.exampleapp.injection.scopes.AppScoped
import dagger.Module
import dagger.Provides


@Module(
    includes = [LocalSourceModule::class]
)
class RepositoryModule {

    @AppScoped
    @Provides
    fun provideRemoteDataSource(api: ImdbApi, prefsHelper: PrefsHelper) = RemoteDataSource(api, prefsHelper)


    @AppScoped
    @Provides
    fun provideMovieRepository(
        remote: RemoteDataSource,
        local: MovieLocalDataSource,
        netManager: NetManager,
    ) = MovieRepository(remote, local, netManager)


}