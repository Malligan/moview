package com.grdk.moview.ui.recentsearches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grdk.moview.recentSearchesDomain.RecentSearchModel
import com.grdk.moview.recentSearchesDomain.RecentSearchModelImpl
import javax.inject.Inject

val tempSearches = listOf(
    RecentSearchModelImpl("19/11/2019", "star wars III"),
    RecentSearchModelImpl("19/11/2019", "harry potter 4")
)

class RecentSearchesViewModel @Inject constructor() : ViewModel() {
    private val _viewState = MutableLiveData<ViewState>(ViewState.Loading)
    val viewState: LiveData<ViewState>
        get() = _viewState

    init {
        loadRecentSearches()
    }

    private fun loadRecentSearches() {
        _viewState.postValue(ViewState.Loading)
        _viewState.postValue(ViewState.Success(tempSearches))
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Success(val recentSearches: List<RecentSearchModel>) : ViewState()
    }
}
