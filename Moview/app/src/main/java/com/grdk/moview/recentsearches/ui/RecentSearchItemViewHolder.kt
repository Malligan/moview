package com.grdk.moview.recentsearches.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recent_search.view.*


class RecentSearchItemViewHolder(
    override val containerView: View,
    private val openSearchListener: ((RecentSearchUiModel) -> Unit)?,
    private val deleteRecentSearchListener: ((RecentSearchUiModel) -> Unit)?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    private var item: RecentSearchUiModel? = null

    init {
        containerView.search.setOnClickListener {
            item?.let { item ->
                openSearchListener?.invoke(item)
            }
        }
        containerView.delete.setOnClickListener {
            item?.let { item ->
                deleteRecentSearchListener?.invoke(item)
            }
        }
    }

    fun bindTo(recentSearchUiModel: RecentSearchUiModel) {
        item = recentSearchUiModel

        containerView.name.text = recentSearchUiModel.name
        containerView.date.text = recentSearchUiModel.date
    }
}