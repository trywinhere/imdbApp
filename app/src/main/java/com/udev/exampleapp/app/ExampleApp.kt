package com.udev.exampleapp.app

import android.os.Build
import com.udev.exampleapp.BuildConfig
import com.udev.exampleapp.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class ExampleApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }


//    @Inject
//    lateinit var translationRepository: TranslationRepository
//
//    @Inject
//    lateinit var connectivityService: ConnectivityService


}