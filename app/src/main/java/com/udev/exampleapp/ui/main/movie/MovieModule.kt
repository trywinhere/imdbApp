package com.udev.exampleapp.ui.main.movie

import androidx.lifecycle.ViewModel
import com.udev.exampleapp.injection.factory.ViewModelKey
import com.udev.exampleapp.injection.scopes.FragmentScoped
import com.udev.exampleapp.ui.main.movielist.MovieListFragment
import com.udev.exampleapp.ui.main.movielist.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MovieModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun movieFragment(): MovieFragment

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindMovieViewModel(viewModel: MovieViewModel): ViewModel

}