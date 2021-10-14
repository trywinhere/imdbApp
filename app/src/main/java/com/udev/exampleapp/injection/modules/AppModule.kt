package com.udev.exampleapp.injection.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(application: Application): Context {
        return application.applicationContext
    }


}