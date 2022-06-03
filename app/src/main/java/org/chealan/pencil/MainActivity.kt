package org.chealan.pencil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView

private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var navView: BottomNavigationView
    private lateinit var railView: NavigationRailView
    private lateinit var toolBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.to_in, R.anim.to_out)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Loading layouts

        viewPager = findViewById(R.id.mainPage_viewPager2)
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        // Setting ViewPager2 Adapter

        navView = findViewById(R.id.mainPage_bottomNavigationView)
        railView = findViewById(R.id.mainPage_railNavigationView)
        toolBar = findViewById(R.id.mainPage_topToolbar)
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_bar_itemA -> {
                    toolBar.title = item.title
                    viewPager.currentItem = 0
                    // Respond to navigation item 1 click
                    true
                }
                R.id.navigation_bar_itemB -> {
                    toolBar.title = item.title
                    viewPager.currentItem = 1
                    // Respond to navigation item 2 click
                    true
                }
                R.id.navigation_bar_itemC -> {
                    toolBar.title = item.title
                    viewPager.currentItem = 2
                    // Respond to navigation item 3 click
                    true
                }
                else -> false
            }
        }
        // Setting BottomNavigationView click,
        // like onClick() in Java

        railView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_bar_itemA -> {
                    toolBar.title = item.title
                    viewPager.currentItem = 0
                    // Respond to navigation item 1 click
                    true
                }
                R.id.navigation_bar_itemB -> {
                    toolBar.title = item.title
                    viewPager.currentItem = 1
                    // Respond to navigation item 2 click
                    true
                }
                R.id.navigation_bar_itemC -> {
                    toolBar.title = item.title
                    viewPager.currentItem = 2
                    // Respond to navigation item 3 click
                    true
                }
                else -> false
            }
        }

        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                navView.selectedItemId = navView.menu.getItem(position).itemId
                railView.selectedItemId = railView.menu.getItem(position).itemId
            }
        })
        // When ViewPager2 selected, do this
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ReturnPage1()
                1 -> ReturnPage2()
                2 -> ReturnPage3()
                else -> {
                    ReturnNull()
                }
            }
        }
        // Setting ViewPager2 Inside
    }


}

