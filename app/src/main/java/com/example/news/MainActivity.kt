package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    private val tabList = listOf("Top", "Politics", "Technology")

    private val topNewsFragment = NewsFragment.newInstance("top")
    private val politicsNewsFragment = NewsFragment.newInstance("politics")
    private val technologyNewsFragment = NewsFragment.newInstance("technology")
    private val fragmentList = listOf(topNewsFragment,politicsNewsFragment,technologyNewsFragment)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = MyPagerAdapter(supportFragmentManager,lifecycle,fragmentList)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabList[position]

        }.attach()

    }
}