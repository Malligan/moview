package com.grdk.moview.newsearch.ui

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.grdk.moview.MainNavigator
import com.grdk.moview.R
import com.grdk.moview.newsearch.domain.NewSearchResultModel
import kotlinx.android.synthetic.main.new_search_fragment.*
import javax.inject.Inject

class NewSearchFragment @Inject constructor(
    viewModelFactory: ViewModelProvider.Factory
) : Fragment() {

    var predefinedTitle: String? = null

    private val mainNavigator by lazy { activity as MainNavigator }

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(
        NewSearchViewModel::class.java) }

    private val viewStateObserver = Observer<NewSearchViewModel.ViewState> {
        when (it) {
            is NewSearchViewModel.ViewState.Success -> {
                showSuccessState(it.newSearchResultModel)
            }
            is NewSearchViewModel.ViewState.Error -> {
                showErrorState(it.message)
            }
            NewSearchViewModel.ViewState.Loading -> {
                showLoadingState()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainNavigator.backAction = Runnable {
            mainNavigator.navigateToRecentSearches()
            mainNavigator.backAction = null
        }

        return inflater.inflate(R.layout.new_search_fragment, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()

        mainNavigator.backAction = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, viewStateObserver)

        if (predefinedTitle != null) {
            search.text = SpannableStringBuilder(predefinedTitle)
            viewModel.loadSearchResult(predefinedTitle as String)
            predefinedTitle = null
        }

        searchButton.setOnClickListener {
            if (search.text?.isEmpty() == true) {
                search.error = "Movie title can't be empty."
            } else {
                viewModel.loadSearchResult(search.text.toString(), true)
                search.error = null
            }
        }
    }

    private fun showSuccessState(newSearchResultModel: NewSearchResultModel) {
        loadingIndicator.visibility = View.GONE

        title.text = newSearchResultModel.title ?: "empty title"
        year.text = newSearchResultModel.year ?: "empty year"
        rated.text = newSearchResultModel.rated ?: "empty rating"
        released.text = newSearchResultModel.released ?: "empty release"
        runtime.text = newSearchResultModel.runtime ?: "empty runtime"
        genre.text = newSearchResultModel.genre ?: "empty genre"
        director.text = newSearchResultModel.director ?: "empty director"
        writer.text = newSearchResultModel.writer ?: "empty writer"
    }

    private fun showErrorState(message: String) {
        loadingIndicator.visibility = View.GONE

        Snackbar
            .make(container, message, Snackbar.LENGTH_LONG)
            .show()
    }

    private fun showLoadingState() {
        loadingIndicator.visibility = View.VISIBLE
    }
}