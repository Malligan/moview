package com.grdk.moview.recentSearchesDomain

interface RecentSearchRepository {
    fun getAll(): List<RecentSearchModel>
}