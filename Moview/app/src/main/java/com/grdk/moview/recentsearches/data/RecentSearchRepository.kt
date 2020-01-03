package com.grdk.moview.recentsearches.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Single
import androidx.room.Delete
import com.grdk.moview.recentsearches.domain.RecentSearchModel


@Dao
interface RecentSearchRepository {
    @Query("SELECT * FROM RecentSearchModel")
    fun getAll(): Flowable<List<RecentSearchModel>>

    @Insert
    fun insertAll(recentSearchModels: List<RecentSearchModel>): Single<List<Long>>

    @Delete
    fun deleteAll(recentSearchModels: List<RecentSearchModel?>)
}