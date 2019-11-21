package com.grdk.moview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grdk.moview.di.MainComponentHolder
import com.grdk.moview.newsearch.ui.NewSearchFragment
import com.grdk.moview.recentsearches.ui.RecentSearchesFragment


class MainActivity : AppCompatActivity(), MainNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = (application as MainComponentHolder).mainComponent.fragmentFactory()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            navigateToRecentSearches()
        }
    }

    override fun onBackPressed() {
        if (backAction != null) {
            backAction?.run()
        } else {
            super.onBackPressed()
        }
    }

    override fun navigateToRecentSearches() {
        val fragment: RecentSearchesFragment = supportFragmentManager.fragmentFactory.instantiate(
            classLoader, RecentSearchesFragment::class.java.canonicalName as String
        ) as RecentSearchesFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

    override fun navigateToNewSearch(title: String?) {
        val fragment: NewSearchFragment = supportFragmentManager.fragmentFactory.instantiate(
            classLoader, NewSearchFragment::class.java.canonicalName as String
        ) as NewSearchFragment

        title?.let { nonNullTitle ->
            fragment.predefinedTitle = nonNullTitle
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

    override var backAction: Runnable? = null
}
