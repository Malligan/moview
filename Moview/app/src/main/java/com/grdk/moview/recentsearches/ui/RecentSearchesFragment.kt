package com.grdk.moview.recentsearches.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grdk.moview.R
import kotlinx.android.synthetic.main.recent_searches_fragment.*
import javax.inject.Inject

class RecentSearchesFragment @Inject constructor(viewModelFactory: ViewModelProvider.Factory) : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(
        RecentSearchesViewModel::class.java) }

    private val recentSearchesAdapter = RecentSearchesAdapter(
        recentSearchListener = {
            // navigate to search with predefined name
        }
    )

    private val recentSearchesObserver = Observer<RecentSearchesViewModel.ViewState> {
        when (it) {
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

        with(searchesRecyclerView) {
            layoutManager = LinearLayoutManager(activity).apply { orientation = RecyclerView.VERTICAL }
            addDividerItemDecoration(R.drawable.list_item_divider)
            adapter = recentSearchesAdapter
        }

        viewModel.viewState.observe(viewLifecycleOwner, recentSearchesObserver)
    }

    private fun showSuccessState(recentSearches: List<RecentSearchUiModel>) {
        recentSearchesAdapter.addItems(recentSearches)
    }

}

private fun RecyclerView.addDividerItemDecoration(@DrawableRes drawableResId: Int) {
    withDrawable(context, drawableResId) {
        addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
            setDrawable(it)
        })
    }
}

private inline fun withDrawable(context: Context, drawableResId: Int, block: (Drawable) -> Unit) {
    ContextCompat.getDrawable(context, drawableResId)?.also(block)
}
