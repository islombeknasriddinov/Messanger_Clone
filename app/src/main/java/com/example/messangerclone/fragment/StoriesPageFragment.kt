package com.example.messangerclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerclone.R
import com.example.messangerclone.adapter.StoriesAdapter
import com.example.messangerclone.model.Stories

class StoriesPageFragment: Fragment() {
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_stories,container,false)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        refreshAdapter(getAllStories())
        return view
    }

    fun getAllStories(): ArrayList<Stories>{
        val stories: ArrayList<Stories> = ArrayList<Stories>()

        stories.add(Stories("",R.drawable.profile, R.drawable.profile))

        for (i in 1..30){
            stories.add(Stories("Islombek Nasriddinov", R.drawable.profile,R.drawable.img_1))
        }

        return stories
    }

    private fun refreshAdapter(stories: ArrayList<Stories>) {
        val adapter = StoriesAdapter(this.requireContext(), stories)
        recyclerView!!.adapter = adapter
    }
}