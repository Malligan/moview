package com.grdk.moview

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.grdk.moview.recentsearches.data.RecentSearchModelImpl
import com.grdk.moview.recentsearches.data.RecentSearchRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@Database(entities = [RecentSearchModelImpl::class], version = 1, exportSchema = false)
abstract class MainDatabase: RoomDatabase() {
    abstract fun recentSearchRepository(): RecentSearchRepository
}

fun RecentSearchRepository.insertInitialData(): Single<List<Long>> {
    return this
        .insertAll(initialSearches)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

val initialSearches = listOf(
    RecentSearchModelImpl(
        date = 1286691000000,
        name = "star wars III"
    ),
    RecentSearchModelImpl(
        date = 1597080000000,
        name = "harry potter 4"
    )
)