package com.example.messangerclone.fragment

import ViewPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.messangerclone.R
import com.google.android.material.tabs.TabLayout

class PeoplePageFragment: Fragment() {
    lateinit var viewPager: ViewPager
    lateinit var tablayout: TabLayout
    lateinit var viewPagerAdapter: ViewPagerAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =inflater.inflate(R.layout.fragment_people, container, false)

        viewPager = view.findViewById(R.id.viewpager)



        viewPagerAdapter = ViewPagerAdapter(childFragmentManager)

        var str: String = "Stories"

        viewPagerAdapter!!.add(StoriesPageFragment(),str)
        viewPagerAdapter!!.add(ActivePageFragment(),"Active")

        viewPager.setAdapter(viewPagerAdapter)

        tablayout = view!!.findViewById<TabLayout>(R.id.tab_layout)
        tablayout.setupWithViewPager(viewPager)

        return view
    }

}