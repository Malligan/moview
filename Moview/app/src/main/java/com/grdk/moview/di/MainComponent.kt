package com.grdk.moview.di

import androidx.fragment.app.FragmentFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MainFactoryModule::class,
        DatabaseModule::class
    ]
)
interface MainComponent {
    fun fragmentFactory(): FragmentFactory
}