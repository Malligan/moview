package com.grdk.moview.di

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class MainFactoryModule {
    @Provides
    fun providesModelFactory(modelFactory: MainViewModelFactory): ViewModelProvider.Factory = modelFactory

    @Provides
    fun providesFragmentFactory(fragmentFactory: MainFragmentFactory): FragmentFactory = fragmentFactory
}