package com.udev.exampleapp.injection.scopes

import kotlin.annotation.Retention
import javax.inject.Scope

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScoped