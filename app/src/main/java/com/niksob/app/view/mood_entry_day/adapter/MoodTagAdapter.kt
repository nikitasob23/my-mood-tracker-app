package com.niksob.app.view.mood_entry_day.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.mood_entry_day.ui_component.MoodTagView
import com.niksob.data.model.UIMoodTag
import com.niksob.data.model.UIMoodTags

class MoodTagAdapter(
    private val moodTags: UIMoodTags,
) : RecyclerView.Adapter<MoodTagAdapter.MoodTagViewHolder>() {

    private val layout = R.layout.mood_tag_view_layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodTagViewHolder {
        val tagView = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)

        return MoodTagViewHolder(tagView)
    }

    override fun onBindViewHolder(holder: MoodTagViewHolder, position: Int) {

        if (position == 0) {
            holder.bindFirstTagView(moodTags.data[position])
            return
        }
        holder.bindTagView(moodTags.data[position])
    }

    override fun getItemCount() = moodTags.data.size

    class MoodTagViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tagView = view as MoodTagView

        fun bindFirstTagView(moodTag: UIMoodTag) {

            bindTagView(moodTag)
//            tagView.isEnvelopsOtherTags = TAG_NOT_ENVELOP_OTHER_TAGS
        }

        fun bindTagView(moodTag: UIMoodTag) {
            tagView.text = moodTag.name
            tagView.color = moodTag.colorId
        }
    }
}