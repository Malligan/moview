package com.grdk.moview.recentsearches.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grdk.moview.initialSearches
import com.grdk.moview.insertInitialData
import com.grdk.moview.recentsearches.domain.RecentSearchModel
import com.grdk.moview.recentsearches.data.RecentSearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecentSearchesViewModel @Inject constructor(
    private val recentSearchRepository: RecentSearchRepository
) : ViewModel() {
    private val disposable = CompositeDisposable()
    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState>
        get() = _viewState

    init {
        loadRecentSearches()
    }

    override fun onCleared() {
        disposable.clear()
    }

    private fun loadRecentSearches() {
        disposable.add(recentSearchRepository.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe{ searches ->
                if (searches.isEmpty()) {
                    recentSearchRepository.insertInitialData().subscribe{ ids ->
                        Log.d("MWV", "items inserted: ${ids.size}")
                        _viewState.postValue(ViewState.Success(initialSearches.toUiModels()))
                    }
                } else {
                    _viewState.postValue(ViewState.Success(searches.toUiModels()))
                }
            })
    }

    sealed class ViewState {
        data class Success(val recentSearches: List<RecentSearchUiModel>) : ViewState()
    }
}
