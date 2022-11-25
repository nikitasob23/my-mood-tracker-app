package com.niksob.app.view.mood_entry_day.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.data.model.UIMoodEntries
import com.niksob.data.model.UIMoodEntry
import com.niksob.data.model.UIMoodTags
import com.niksob.domain.model.ColorId
import com.niksob.domain.utils.date.localTime

private const val LAYOUT_IS_REVERSED = false

class MoodEntryAdapter(
    private val moodEntries: UIMoodEntries,
) : RecyclerView.Adapter<MoodEntryAdapter.MoodEntryViewHolder>() {

    private val layout = R.layout.mood_entry_layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodEntryViewHolder {
        val entryView = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)

        return MoodEntryViewHolder(entryView)
    }

    override fun onBindViewHolder(holder: MoodEntryViewHolder, position: Int) {
        holder.bindView(moodEntries.data[position])
    }

    override fun getItemCount() = moodEntries.data.size

    class MoodEntryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val containerLinearLayout: LinearLayout = itemView.findViewById(R.id.mood_entry_layout__container)
        private val emojiImageView: ImageView = itemView.findViewById(R.id.mood_entry_layout__emoji_iv)
        private val timeTextView: TextView = itemView.findViewById(R.id.mood_entry_layout__time_tv)
        private val moodTagRecyclerView: RecyclerView =
            itemView.findViewById(R.id.mood_entry_layout__mood_tag_recycle_view)

        fun bindView(entry: UIMoodEntry) {
            setBackgroundColor(entry.colorId)
            setEmoji(entry.emoji)
            setTitle(entry.title)
            setTime(entry.dateTime.localTime)
            initMoodTagAdapter(entry.tags)
            entry.onClick?.apply { setOnClickAction(action = this) }
        }

        private fun setBackgroundColor(colorId: ColorId?) {
            if (colorId == null) {
                return
            }
            val container = containerLinearLayout.background as Drawable
            container.setTint(colorId.data)
        }

        private fun setEmoji(emoji: Drawable?) {
            if (emoji == null) {
                return
            }
            emojiImageView.background = emoji
        }

        private fun setTitle(title: String) {
            timeTextView.text = title
        }

        private fun setTime(time: String) {
            timeTextView.text = time
        }

        private fun setOnClickAction(action: () -> Unit) {
            containerLinearLayout.setOnClickListener { action.invoke() }
        }

        private fun initMoodTagAdapter(tags: UIMoodTags) {

            moodTagRecyclerView.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, LAYOUT_IS_REVERSED)
                adapter = MoodTagAdapter(tags)
            }
        }
    }
}