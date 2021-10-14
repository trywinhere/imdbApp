package com.udev.exampleapp.injection.component

import android.app.Application
import com.udev.exampleapp.app.ExampleApp
import com.udev.exampleapp.injection.factory.ViewModelBuilder
import com.udev.exampleapp.injection.modules.ActivityBindingModule
import com.udev.exampleapp.injection.modules.AppModule
import com.udev.exampleapp.injection.modules.NetworkModule
import com.udev.exampleapp.injection.modules.RepositoryModule
import com.udev.exampleapp.injection.scopes.AppScoped
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScoped
@Component(
    modules = [AndroidInjectionModule::class,
        RepositoryModule::class,
        AppModule::class,
        ViewModelBuilder::class,
        ActivityBindingModule::class,
        NetworkModule::class,
//        RoomModule::class

    ]
)
interface AppComponent : AndroidInjector<ExampleApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}