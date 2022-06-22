package com.niksob.app.view.moodentry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.app.view.moodentry.uicomponent.MoodTagView
import com.niksob.domain.model.MoodTag

class AdditionMoodEntryViewTagAdapter(
    private val moodTags: List<MoodTag>
) : RecyclerView.Adapter<AdditionMoodEntryViewTagAdapter.AdditionMoodEntryViewTagViewHolder>() {

    private val layout = R.layout.mood_tag_view_layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdditionMoodEntryViewTagViewHolder {
        val rooView = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)

        return AdditionMoodEntryViewTagViewHolder(rooView)
    }

    override fun onBindViewHolder(holder: AdditionMoodEntryViewTagViewHolder, position: Int) {
        holder.bindView(moodTags[position])
    }

    override fun getItemCount() = moodTags.size

    class AdditionMoodEntryViewTagViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val moodTagView: MoodTagView = itemView.findViewById(R.id.mood_tag_view_layout__container)

        fun bindView(moodTag: MoodTag) {
            moodTagView.name = moodTag.name
            moodTagView.color = moodTag.colorId
        }
    }
}