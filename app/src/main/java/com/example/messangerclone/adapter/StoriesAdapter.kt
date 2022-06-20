package com.example.messangerclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messangerclone.R
import com.example.messangerclone.model.Stories

class StoriesAdapter(var context: Context, var items: ArrayList<Stories>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEADER = 1
    private val TYPE_ITEM_VIEW = 2

    override fun getItemViewType(position: Int): Int {
        return if (isHeader(position)) TYPE_ITEM_HEADER else TYPE_ITEM_VIEW

    }

    fun isHeader(position: Int): Boolean {
        return position == 0
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val stories = items[position]

        if (holder is StoriesHeaderViewHolder){
            var iv_photo = holder.iv_photo

            iv_photo.setImageResource(stories.photo)
        }

        if (holder is StoriesViewHolder){
            var iv_photo = holder.iv_photo
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname

            iv_photo.setImageResource(stories.photo)
            iv_profile.setImageResource(stories.profile)
            tv_fullname.text = stories.fullname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_HEADER) {
            val header = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_add_stories, parent, false)
            return StoriesHeaderViewHolder(header)
        }

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_stories_view, parent, false)
        return StoriesViewHolder(view)
    }

    class StoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_photo: ImageView
        var iv_profile: ImageView
        var tv_fullname: TextView

        init {
            iv_photo = view.findViewById(R.id.iv_photo)
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }

    class StoriesHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_photo: ImageView

        init {
            iv_photo = view.findViewById(R.id.iv_photo)
        }
    }
}