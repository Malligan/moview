package com.grdk.moview.recentSearchesDomain

data class RecentSearchModelImpl(
    override val date: String,
    override val name: String
) : RecentSearchModel