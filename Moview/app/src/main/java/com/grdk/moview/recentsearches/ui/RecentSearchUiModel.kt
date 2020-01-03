package com.grdk.moview.recentsearches.ui

import com.grdk.moview.recentsearches.domain.RecentSearchModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

data class RecentSearchUiModel(
    val rawDate: Long,
    val date: String,
    val name: String,
    val id: Int
)

var recentSearchDateFormat: DateFormat = SimpleDateFormat("dd/MM/yy", Locale.getDefault())

fun List<RecentSearchModel>.toUiModels(): List<RecentSearchUiModel> {
    return this.map { it.toUiModel() }
}

fun RecentSearchModel.toUiModel(): RecentSearchUiModel {
    val calendar = GregorianCalendar()
    calendar.timeInMillis = this.date
    return RecentSearchUiModel(this.date, recentSearchDateFormat.format(calendar.time), this.name, this.id)
}