package com.udev.exampleapp.injection.network.error

import java.io.IOException


class NoConnectivityException(override var message: String) : IOException(message){

}