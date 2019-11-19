package com.grdk.moview

import android.app.Application
import com.grdk.moview.di.DaggerMainComponent
import com.grdk.moview.di.MainComponent
import com.grdk.moview.di.MainComponentHolder

class MainApplication: Application(), MainComponentHolder {
    lateinit var daggerComponent: MainComponent

    override fun onCreate() {
        super.onCreate()

        daggerComponent = DaggerMainComponent
            .builder()
            //.databaseModule.create(DatabaseModule(appContext))
            .build()
    }

    override val mainComponent: MainComponent
        get() = daggerComponent
}