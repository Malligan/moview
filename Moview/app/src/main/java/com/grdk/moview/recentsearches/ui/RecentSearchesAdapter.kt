package com.grdk.moview.recentsearches.ui

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class RecentSearchesAdapter(
    recentSearchListener: ((RecentSearchUiModel) -> Unit)?
) : ListDelegationAdapter<MutableList<RecentSearchUiModel>>() {
    init {
        delegatesManager.addDelegate(RecentSearchesAdapterDelegate(recentSearchListener))
        items = mutableListOf()
    }

    fun addItems(recentSearchUiModels: List<RecentSearchUiModel>) {
        items.clear()
        items.addAll(recentSearchUiModels)
        notifyDataSetChanged()
    }
}