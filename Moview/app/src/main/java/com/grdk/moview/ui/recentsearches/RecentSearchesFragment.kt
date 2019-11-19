package com.grdk.moview.ui.recentsearches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.grdk.moview.R
import com.grdk.moview.recentSearchesDomain.RecentSearchModel
import kotlinx.android.synthetic.main.recent_searches_fragment.*
import javax.inject.Inject

class RecentSearchesFragment @Inject constructor(viewModelFactory: ViewModelProvider.Factory) : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(RecentSearchesViewModel::class.java) }

    private val recentSearchesObserver = Observer<RecentSearchesViewModel.ViewState> {
        when (it) {
            RecentSearchesViewModel.ViewState.Loading -> {
                showLoadingState()
            }
            is RecentSearchesViewModel.ViewState.Success -> {
                showSuccessState(it.recentSearches)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.recent_searches_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, recentSearchesObserver)
    }

    private fun showLoadingState() {

    }

    private fun showSuccessState(recentSearches: List<RecentSearchModel>) {
        errorMessage.text = recentSearches.first().name
    }

    private fun showErrorState() {

    }

}
