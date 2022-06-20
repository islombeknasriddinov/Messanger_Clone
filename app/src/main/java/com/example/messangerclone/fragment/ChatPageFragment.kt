package com.example.messangerclone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerclone.R
import com.example.messangerclone.adapter.ChatAdapter
import com.example.messangerclone.model.Chat
import com.example.messangerclone.model.Message
import com.example.messangerclone.model.Room

class ChatPageFragment: Fragment() {

    lateinit var recyclerView: RecyclerView

    private fun getAllChats(): ArrayList<Chat> {
        val stories: ArrayList<Room> = ArrayList<Room>()

        for (i in 1..50){
            stories.add(Room(R.drawable.profile, "Islombek"))
        }

        val chats: ArrayList<Chat> = ArrayList<Chat>()

        chats.add(Chat(stories))

        for (i in 1..50){
            chats.add(Chat(Message(R.drawable.profile, "Islombek Nasriddinov", true)))
        }

        return chats
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this.requireContext(),chats)
        recyclerView!!.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =inflater.inflate(R.layout.fragment_chat, container, false)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setLayoutManager(LinearLayoutManager(activity))
        refreshAdapter(getAllChats())
        return view
    }
}