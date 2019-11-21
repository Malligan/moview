package com.grdk.moview

interface MainNavigator {
    fun navigateToRecentSearches()
    fun navigateToNewSearch(title: String? = null)
    var backAction: Runnable?
}