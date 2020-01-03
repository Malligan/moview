package com.grdk.moview.recentsearches.ui

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class RecentSearchesAdapter(
    openSearchListener: ((RecentSearchUiModel) -> Unit)?,
    deleteRecentSearchListener: ((RecentSearchUiModel) -> Unit)?
) : ListDelegationAdapter<MutableList<RecentSearchUiModel>>() {
    init {
        delegatesManager.addDelegate(RecentSearchesAdapterDelegate(openSearchListener, deleteRecentSearchListener))
        items = mutableListOf()
    }

    fun addItems(recentSearchUiModels: List<RecentSearchUiModel>) {
        items.clear()
        items.addAll(recentSearchUiModels)
        notifyDataSetChanged()
    }
}