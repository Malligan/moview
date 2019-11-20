package com.grdk.moview.di

import android.content.Context
import androidx.room.Room
import com.grdk.moview.MainDatabase
import com.grdk.moview.recentsearches.data.RecentSearchRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val appContext: Context) {

    @Provides
    @Singleton
    fun providesMainDatabase(): MainDatabase {
        return Room
            .databaseBuilder(appContext, MainDatabase::class.java, "database-main")
            .build()
    }

    @Provides
    @Singleton
    fun providesRecentSearchRepository(mainDatabase: MainDatabase): RecentSearchRepository =
        mainDatabase.recentSearchRepository()
}