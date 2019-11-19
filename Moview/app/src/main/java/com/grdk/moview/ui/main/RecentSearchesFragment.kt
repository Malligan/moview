package com.grdk.moview.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grdk.moview.R

class RecentSearchesFragment : Fragment() {

    companion object {
        fun newInstance() = RecentSearchesFragment()
    }

    private lateinit var viewModel: RecentSearchesModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.recent_searches_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecentSearchesModel::class.java)
        // TODO: Use the ViewModel
    }

}
