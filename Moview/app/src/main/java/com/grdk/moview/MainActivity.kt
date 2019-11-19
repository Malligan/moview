package com.grdk.moview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grdk.moview.ui.main.RecentSearchesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecentSearchesFragment.newInstance())
                .commitNow()
        }
    }

}
