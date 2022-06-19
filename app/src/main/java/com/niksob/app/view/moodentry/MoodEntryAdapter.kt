package com.niksob.app.view.moodentry

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.niksob.app.R
import com.niksob.domain.model.MoodEntry
import com.niksob.domain.utils.date.localTime


class MoodEntryAdapter(
    private val moodEntries: List<MoodEntry>,
    private val context: Context,
) : RecyclerView.Adapter<MoodEntryAdapter.MoodEntryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodEntryViewHolder {
        val entryView = LayoutInflater.from(parent.context)
            .inflate(R.layout.mood_entry_layout, parent, false)

        return MoodEntryViewHolder(entryView)
    }

    override fun onBindViewHolder(holder: MoodEntryViewHolder, position: Int) {
        holder.bindView(moodEntries[position], context)
    }

    override fun getItemCount() = moodEntries.size

    class MoodEntryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val containerLinearLayout: LinearLayout = itemView.findViewById(R.id.mood_entry_layout__container)
        private val emojiImageView: ImageView = itemView.findViewById(R.id.mood_entry_layout__emoji_iv)
        private val timeTextView: TextView = itemView.findViewById(R.id.mood_entry_layout__time_tv)

        fun bindView(entry: MoodEntry, context: Context) {
            setBackgroundColor(entry.colorId)
            setEmoji(context, entry.emojiId)
            setTime(entry.dateTime.localTime)
        }

        private fun setBackgroundColor(colorId: Int) {
            val container = containerLinearLayout.background as Drawable
            container.setTint(colorId)
        }

        private fun setEmoji(context: Context, emojiId: Int) {
            emojiImageView.background = AppCompatResources.getDrawable(context, emojiId)
        }

        private fun setTime(time: String) {
            timeTextView.text = time
        }
    }
}