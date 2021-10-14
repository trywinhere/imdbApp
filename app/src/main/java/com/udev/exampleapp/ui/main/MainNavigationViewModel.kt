package com.udev.exampleapp.ui.main

import android.os.Bundle
import com.udev.exampleapp.injection.scopes.AppScoped
import com.udev.exampleapp.ui.BaseViewModel
import com.udev.exampleapp.ui.Navigator
import javax.inject.Inject

@AppScoped
class MainNavigationViewModel @Inject constructor(): BaseViewModel() {

    private lateinit var appNavigator: Navigator

    fun setNavigator(navigator: Navigator) {
        appNavigator = navigator
    }

    fun navigateTo(navigation: Int, bundle: Bundle? = null) {
        appNavigator.navigate(navigation, bundle)
    }


    fun onBackClick() {
        appNavigator.onBackClick()
    }

}