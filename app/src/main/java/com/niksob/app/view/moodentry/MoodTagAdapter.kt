package com.niksob.app.view.moodentry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.moodentry.uicomponent.MoodTagView
import com.niksob.app.view.moodentry.uicomponent.TAG_NOT_ENVELOP_OTHER_TAGS
import com.niksob.domain.model.MoodTag


class MoodTagAdapter(
    private val moodTags: List<MoodTag>,
) : RecyclerView.Adapter<MoodTagAdapter.MoodTagViewHolder>() {

    private val layout = R.layout.mood_tag_view_layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodTagViewHolder {
        val tagView = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)

        return MoodTagViewHolder(tagView)
    }

    override fun onBindViewHolder(holder: MoodTagViewHolder, position: Int) {

        if (position == 0) {
            holder.bindFirstTagView(moodTags[position])
            return
        }
        holder.bindTagView(moodTags[position])
    }

    override fun getItemCount() = moodTags.size

    class MoodTagViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tagView = view as MoodTagView

        fun bindFirstTagView(moodTag: MoodTag) {

            bindTagView(moodTag)
            tagView.isEnvelopsOtherTags = TAG_NOT_ENVELOP_OTHER_TAGS
        }

        fun bindTagView(moodTag: MoodTag) {
            tagView.text = moodTag.name
            tagView.color = moodTag.colorId
        }
    }
}