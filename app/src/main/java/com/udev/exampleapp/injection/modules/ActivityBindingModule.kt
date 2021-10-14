package com.udev.exampleapp.injection.modules

import com.udev.exampleapp.injection.scopes.ActivityScoped
import com.udev.exampleapp.ui.NavigationModule
import com.udev.exampleapp.ui.main.MainActivity
import com.udev.exampleapp.ui.main.movie.MovieModule
import com.udev.exampleapp.ui.main.movielist.MovieListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            NavigationModule::class,
            MovieListModule::class,
            MovieModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity

}