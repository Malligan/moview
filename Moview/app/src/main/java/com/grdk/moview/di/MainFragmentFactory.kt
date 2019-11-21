package com.grdk.moview.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.grdk.moview.newsearch.ui.NewSearchFragment
import com.grdk.moview.recentsearches.ui.RecentSearchesFragment
import javax.inject.Inject
import javax.inject.Provider

class MainFragmentFactory @Inject constructor(
    private val recentSearchesFragmentProvider: Provider<RecentSearchesFragment>,
    private val newSearchFragmentProvider: Provider<NewSearchFragment>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            RecentSearchesFragment::class.java.canonicalName -> recentSearchesFragmentProvider.get()
            NewSearchFragment::class.java.canonicalName -> newSearchFragmentProvider.get()
            else -> TODO("Missing fragment $className")
        }
    }
}