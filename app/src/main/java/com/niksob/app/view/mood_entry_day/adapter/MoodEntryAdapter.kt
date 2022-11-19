package com.niksob.app.view.mood_entry_day.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.domain.model.MoodEntries
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.model.MoodTag
import com.niksob.domain.utils.date.localTime

private const val LAYOUT_IS_REVERSED = false

class MoodEntryAdapter(
    private val moodEntries: MoodEntries,
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

        fun bindView(entry: MoodEntry) {
            setBackgroundColor(entry.colorId)
            setEmoji(entry.emojiId)
            setTime(entry.dateTime.localTime)
            initMoodTagAdapter(entry.tags)
            entry.clickCallback?.apply { setOnClickAction(action = this) }
        }

        private fun setBackgroundColor(colorId: Int) {
            val container = containerLinearLayout.background as Drawable
            container.setTint(colorId)
        }

        private fun setEmoji(emojiId: Int) {
            emojiImageView.background = AppCompatResources.getDrawable(itemView.context, emojiId)
        }

        private fun setTime(time: String) {
            timeTextView.text = time
        }

        private fun setOnClickAction(action: () -> Unit) {
            containerLinearLayout.setOnClickListener { action.invoke() }
        }

        private fun initMoodTagAdapter(tags: List<MoodTag>) {

            moodTagRecyclerView.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, LAYOUT_IS_REVERSED)
                adapter = MoodTagAdapter(tags)
            }
        }
    }
}