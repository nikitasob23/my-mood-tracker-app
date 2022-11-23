package com.niksob.di.module.view.mood_entry.ui_component

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.niksob.app.R
import com.niksob.app.view.mood_entry.ui_component.MoodEntryPanelView
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MoodEntryPanelViewModule(
    private val view: View,
) {

    @Provides
    fun provideMoodEntryPanelView(
        panelContainerConstraintLayout: ConstraintLayout,
        emojiImageView: ImageView,
        @Named("time_text_view") timeTextView: TextView,
        @Named("title_text_view") titleTextView: TextView,
        saveButtonFrameLayout: FrameLayout,
    ) = MoodEntryPanelView(
        panelContainerConstraintLayout = panelContainerConstraintLayout,
        emojiImageView = emojiImageView,
        timeTextView = timeTextView,
        titleTextView = titleTextView,
        saveButtonFrameLayout = saveButtonFrameLayout,
    )

    @Provides
    fun providePanelContainerConstraintLayout(): ConstraintLayout =
        view.findViewById(R.id.addition_mood_entry_panel_layout__container_cl)

    @Provides
    fun provideEmojiImageView(): ImageView = view.findViewById(R.id.addition_mood_entry_view_layout__mood_entry__emoji)

    @Provides
    @Named("time_text_view")
    fun provideTimeTextView(): TextView = view.findViewById(R.id.addition_mood_entry_view_layout__mood_entry__time)

    @Provides
    @Named("title_text_view")
    fun provideTitleTextView(): TextView = view.findViewById(R.id.addition_mood_entry_view_layout__mood_entry__title)

    @Provides
    fun provideSaveButtonFrameLayout(): FrameLayout =
        view.findViewById(R.id.addition_mood_entry_view_layout__mood_entry__save_btn)
}