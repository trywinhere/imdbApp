package com.udev.exampleapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udev.exampleapp.injection.component.ViewModelInjector
import com.udev.exampleapp.injection.modules.RepositoryModule
import com.udev.exampleapp.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineExceptionHandler
import com.udev.exampleapp.injection.component.DaggerViewModelInjector
import timber.log.Timber
import javax.inject.Inject


abstract class BaseViewModel : ViewModel() {

    val onErrorEvent = SingleLiveEvent<String>()

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .repositoryModule(RepositoryModule())
        .build()

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Timber.e(exception)
    }

    var disposable: CompositeDisposable = CompositeDisposable()

    init {
        inject()
    }

    private fun inject() {
        injector.inject(this)
    }

}