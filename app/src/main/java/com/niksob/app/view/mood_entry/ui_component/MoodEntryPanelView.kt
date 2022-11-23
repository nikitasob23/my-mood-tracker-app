package com.niksob.app.view.mood_entry.ui_component

import android.graphics.drawable.GradientDrawable
import android.view.View.OnClickListener
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.niksob.app.view.base.ui_components.ViewComponent
import com.niksob.data.model.UIMoodEntry
import com.niksob.domain.model.ColorId
import com.niksob.domain.utils.date.localTime
import java.time.ZonedDateTime

class MoodEntryPanelView(
    private val panelContainerConstraintLayout: ConstraintLayout, //needed to set panel color
    private val emojiImageView: ImageView,
    private val timeTextView: TextView,
    private val titleTextView: TextView,
    private val saveButtonFrameLayout: FrameLayout, //button which save new mood entry and navigate us back to MoodEntryDayView
) : ViewComponent<UIMoodEntry> {

    private val panelGradientDrawableBackground get() = panelContainerConstraintLayout.background as GradientDrawable

    override fun bind(data: UIMoodEntry) =
        listOf(data)
            .onEach(this::setEmoji)
            .onEach(this::setTime)
            .onEach(this::setTitle)
            .onEach(this::setColor)
            .forEach(this::onPanelClicked) //make mood entry panel clickable

    private fun setEmoji(moodEntry: UIMoodEntry) =
        sequenceOf(moodEntry)
            .map(UIMoodEntry::emoji)
            .filterNotNull()
            .forEach(emojiImageView::setBackground)

    private fun setTime(moodEntry: UIMoodEntry) =
        sequenceOf(moodEntry)
            .map(UIMoodEntry::dateTime)
            .map(ZonedDateTime::localTime)
            .forEach(timeTextView::setText)

    private fun setTitle(moodEntry: UIMoodEntry) =
        sequenceOf(moodEntry)
            .map(UIMoodEntry::title)
            .forEach(titleTextView::setText)

    private fun setColor(moodEntry: UIMoodEntry) =
        sequenceOf(moodEntry.colorId)
            .onEach(this::setPanelColor)
            .forEach(this::setSaveBtnColor)

    private fun setPanelColor(colorId: ColorId?) =
        sequenceOf(colorId)
            .filterNotNull()
            .map(ColorId::data)
            .forEach(panelGradientDrawableBackground::setTint)

    private fun setSaveBtnColor(colorId: ColorId?) =
        sequenceOf(colorId)
            .filterNotNull()
            .map(ColorId::data)
            .forEach { saveButtonFrameLayout.background.setTint(it) }

    private fun onPanelClicked(moodEntry: UIMoodEntry) =
        sequenceOf(moodEntry.onClick)
            .filterNotNull()
            .map { onClick -> OnClickListener { onClick.invoke() } } //convert onClick Callback to OnClickListener
            .forEach(panelContainerConstraintLayout::setOnClickListener)
}