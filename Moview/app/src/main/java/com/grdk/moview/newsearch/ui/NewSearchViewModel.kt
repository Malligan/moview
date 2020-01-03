package com.grdk.moview.newsearch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grdk.moview.newsearch.domain.NewSearchResultModel
import com.grdk.moview.newsearch.data.NewSearchService
import com.grdk.moview.recentsearches.domain.RecentSearchModel
import com.grdk.moview.recentsearches.data.RecentSearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class NewSearchViewModel @Inject constructor(
    private val newSearchService: NewSearchService,
    private val recentSearchRepository: RecentSearchRepository
) : ViewModel() {
    private val disposable = CompositeDisposable()
    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState>
        get() = _viewState

    override fun onCleared() {
        disposable.clear()
    }

    fun loadSearchResult(title: String, isNewSearch: Boolean = false) {
        _viewState.postValue(ViewState.Loading)

        disposable.add(newSearchService.getSearchResult(title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { searchResult ->
                    if (searchResult.body() != null) {
                        _viewState.postValue(ViewState.Success(searchResult.body() as NewSearchResultModel))
                    } else {
                        _viewState.postValue(ViewState.Error("Receiving data is failed, code: ${searchResult.code()}"))
                    }
                },
                onError = {
                    _viewState.postValue(ViewState.Error(it.message ?: "Something wrong, try again later"))
                }
            ))

        if (isNewSearch) {
            val dataToInsert = listOf(
                RecentSearchModel(
                    date = Calendar.getInstance().time.time,
                    name = title
                )
            )
            disposable.add(recentSearchRepository.insertAll(dataToInsert)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ ids ->
                Log.d("MWV", "items inserted: ${ids.size}")
            })
        }
    }

    sealed class ViewState {
        data class Success(val newSearchResultModel: NewSearchResultModel) : ViewState()
        data class Error(val message: String) : ViewState()
        object Loading : ViewState()
    }
}