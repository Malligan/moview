package com.grdk.moview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grdk.moview.di.MainComponentHolder
import com.grdk.moview.ui.recentsearches.RecentSearchesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = (application as MainComponentHolder).mainComponent.fragmentFactory()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val fragment = supportFragmentManager.fragmentFactory.instantiate(
            classLoader, RecentSearchesFragment::class.java.canonicalName as String
        )

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        }
    }

}
