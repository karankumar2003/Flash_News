package com.example.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentManager: FragmentManager,lifecycle:Lifecycle,val list:List<Fragment>) : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
       return list[position]

    }

}