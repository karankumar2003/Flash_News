package com.example.news

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(){
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    private val tabList = listOf("Top", "Politics", "Technology")

    private val topNewsFragment = NewsFragment.newInstance("top")
    private val politicsNewsFragment = NewsFragment.newInstance("politics")
    private val technologyNewsFragment = NewsFragment.newInstance("technology")
    private val fragmentList = listOf(topNewsFragment,politicsNewsFragment,technologyNewsFragment)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabLayout)
        tabLayout.setBackgroundColor(ContextCompat.getColor(applicationContext,R.color.red))
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE)

        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = MyPagerAdapter(supportFragmentManager,lifecycle,fragmentList)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabList[position]

        }.attach()

    }


}