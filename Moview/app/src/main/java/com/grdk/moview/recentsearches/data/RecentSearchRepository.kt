package com.grdk.moview.recentsearches.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface RecentSearchRepository {
    @Query("SELECT * FROM RecentSearchModelImpl")
    fun getAll(): Flowable<List<RecentSearchModelImpl>>

    @Insert
    fun insertAll(recentSearchModels: List<RecentSearchModelImpl>): Single<List<Long>>
}