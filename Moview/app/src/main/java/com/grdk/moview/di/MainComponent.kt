package com.grdk.moview.di

import androidx.fragment.app.FragmentFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MainFactoryModule::class,
        DatabaseModule::class,
        ServiceModule::class
    ]
)
interface MainComponent {
    fun fragmentFactory(): FragmentFactory
}

interface MainComponentHolder {
    val mainComponent: MainComponent
}