package com.udev.exampleapp.ui.main

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.udev.exampleapp.ui.BaseFragment
import com.udev.exampleapp.ui.BaseViewModel
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


abstract class BaseMainFragment <T : BaseViewModel, VB : ViewDataBinding>(mResContent: Int) :
    BaseFragment<T, VB>(mResContent) {

    lateinit var navigationViewModel: MainNavigationViewModel

    fun getNavigationModel(): MainNavigationViewModel {
        return ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(MainNavigationViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationViewModel = getNavigationModel()
    }
}
