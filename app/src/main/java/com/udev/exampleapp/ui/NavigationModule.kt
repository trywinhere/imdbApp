package com.udev.exampleapp.ui

import androidx.lifecycle.ViewModel
import com.udev.exampleapp.injection.factory.ViewModelKey
import com.udev.exampleapp.ui.main.MainNavigationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NavigationModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainNavigationViewModel::class)
    abstract fun bindMainNavigationViewModel(viewModel: MainNavigationViewModel): ViewModel
}