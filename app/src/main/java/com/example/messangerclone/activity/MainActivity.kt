package com.example.messangerclone.activity

import ViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.viewpager.widget.ViewPager
import com.example.messangerclone.R
import com.example.messangerclone.fragment.ActivePageFragment
import com.example.messangerclone.fragment.ChatPageFragment
import com.example.messangerclone.fragment.PeoplePageFragment
import com.example.messangerclone.fragment.StoriesPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val chatPageFragment = ChatPageFragment()
    private val peoplePageFragment = PeoplePageFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
       replaceFragment(chatPageFragment)

       var bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

       bottom_navigation.setOnNavigationItemSelectedListener {
           when(it.itemId){
               R.id.nav_chats -> replaceFragment(chatPageFragment)
               R.id.nav_people -> replaceFragment(peoplePageFragment)
           }
           true
       }

    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }







}