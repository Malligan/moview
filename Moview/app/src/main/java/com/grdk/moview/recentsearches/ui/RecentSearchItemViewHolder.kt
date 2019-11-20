package com.grdk.moview.recentsearches.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recent_search.view.*


class RecentSearchItemViewHolder(
    override val containerView: View,
    private val depositActivityItemListener: ((RecentSearchUiModel) -> Unit)?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    private var item: RecentSearchUiModel? = null

    init {
        containerView.recentSearchItemContainer.setOnClickListener {
            item?.let { item ->
                depositActivityItemListener?.invoke(item)
                bindTo(item)
            }
        }
    }

    fun bindTo(recentSearchUiModel: RecentSearchUiModel) {
        item = recentSearchUiModel

        containerView.name.text = recentSearchUiModel.name
        containerView.date.text = recentSearchUiModel.date
    }
}