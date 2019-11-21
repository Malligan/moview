package com.grdk.moview.recentsearches.ui

import com.grdk.moview.initialSearches
import org.junit.Assert.*
import org.junit.Test

class RecentSearchUiModelTest {

    private val expectedDate = "10/10/10"

    @Test
    fun testDateReading() {
        val dbModel = initialSearches.first()
        val uiModel = dbModel.toUiModel()
        assertEquals(uiModel.date, expectedDate)
    }
}