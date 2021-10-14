package com.udev.exampleapp.injection.component

import androidx.lifecycle.ViewModel
import com.udev.exampleapp.injection.modules.RepositoryModule
import com.udev.exampleapp.injection.scopes.AppScoped
import dagger.Component

@AppScoped
@Component(modules = [RepositoryModule::class])
interface ViewModelInjector {

    fun inject(viewModel: ViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun repositoryModule(repositoryModule: RepositoryModule): Builder
    }
}