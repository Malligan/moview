package com.grdk.moview.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grdk.moview.newsearch.ui.NewSearchViewModel
import com.grdk.moview.recentsearches.ui.RecentSearchesViewModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class MainViewModelFactory @Inject constructor(
    private val recentSearchesViewModel: Provider<RecentSearchesViewModel>,
    private val newSearchViewModel: Provider<NewSearchViewModel>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            RecentSearchesViewModel::class.java -> recentSearchesViewModel.get()
            NewSearchViewModel::class.java -> newSearchViewModel.get()
            else -> TODO("Missing viewModel $modelClass")
        } as T
    }
}