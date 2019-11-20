package com.grdk.moview.recentsearches.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.grdk.moview.recentsearches.domain.RecentSearchModel

@Entity
data class RecentSearchModelImpl(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    @ColumnInfo(name = "date")
    override val date: Long,
    @ColumnInfo(name = "name")
    override val name: String
) : RecentSearchModel