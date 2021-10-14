package com.udev.exampleapp.ui.main.movielist

import androidx.lifecycle.ViewModel
import com.udev.exampleapp.injection.factory.ViewModelKey
import com.udev.exampleapp.injection.scopes.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MovieListModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun movieListFragment(): MovieListFragment

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindMovieListViewModel(viewModel: MovieListViewModel): ViewModel

}