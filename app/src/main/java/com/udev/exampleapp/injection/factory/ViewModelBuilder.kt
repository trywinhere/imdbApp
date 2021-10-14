package com.udev.exampleapp.injection.factory

import androidx.lifecycle.ViewModelProvider
import com.udev.exampleapp.injection.factory.DaggerAwareViewModelFactory
import dagger.Binds
import dagger.Module


@Module
internal abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerAwareViewModelFactory):
            ViewModelProvider.Factory
}