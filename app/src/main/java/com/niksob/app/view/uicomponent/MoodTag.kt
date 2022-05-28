package com.niksob.app.view.uicomponent

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.niksob.app.R

class MoodTag(
    context: Context,
    attrs: AttributeSet,
    color: Int = R.color.excellent_tag_background
) : LinearLayout(context, attrs) {

    private val layout = R.layout.mood_tag

    private lateinit var tail: AppCompatImageView
    private lateinit var body: AppCompatTextView
    private lateinit var head: AppCompatImageView

    var color: Int = color
        set(value) {
            field = value
            changeColor()
        }

    init {
        LayoutInflater.from(context).inflate(layout, null)
        initComponents()
    }

    private fun initComponents() {
        tail = findViewById(R.id.mood_tag__tail_iv)
        body = findViewById(R.id.mood_tag__body_tv)
        head = findViewById(R.id.mood_tag__head_iv)
    }

    private fun changeColor() {
        tail.setBackgroundColor(color)
        body.setBackgroundColor(color)
        head.setBackgroundColor(color)
    }
}