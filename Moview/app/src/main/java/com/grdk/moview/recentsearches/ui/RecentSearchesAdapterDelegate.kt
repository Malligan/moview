package com.grdk.moview.recentsearches.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.grdk.moview.R
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class RecentSearchesAdapterDelegate(
    private val recentSearchListener: ((RecentSearchUiModel) -> Unit)?
) : AbsListItemAdapterDelegate<RecentSearchUiModel, RecentSearchUiModel, RecentSearchItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): RecentSearchItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recent_search, parent, false)
        return RecentSearchItemViewHolder(view, recentSearchListener)
    }

    override fun isForViewType(item: RecentSearchUiModel, items: MutableList<RecentSearchUiModel>, position: Int): Boolean {
        return true // single type of items, always true
    }

    override fun onBindViewHolder(item: RecentSearchUiModel, holder: RecentSearchItemViewHolder, payloads: MutableList<Any>) {
        holder.bindTo(item)
    }
}