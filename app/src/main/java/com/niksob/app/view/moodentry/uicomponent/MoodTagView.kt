package com.niksob.app.view.moodentry.uicomponent

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.niksob.app.R


private const val BACKGROUND_ATTR = R.styleable.MoodTagView_android_background
private const val TEXT_ATTR = R.styleable.MoodTagView_android_text
private const val DEF_TEXT_ATTR = ""


class MoodTagView(
    context: Context,
    attrs: AttributeSet,
) : LinearLayout(context, attrs) {

    var color = R.color.grey
        set(value) {
            field = value
            changeColor()
        }

    var name = ""
        set(value) {
            field = value
            changeText()
        }

    private lateinit var tail: AppCompatImageView
    private lateinit var body: FrameLayout
    private lateinit var head: AppCompatImageView

    private lateinit var textView: AppCompatTextView
    private lateinit var imageView: AppCompatImageView

    private val viewAttrsId = R.styleable.MoodTagView

    private val backgroundDrawable: Drawable?

    private val hasText
        get() = name.isNotEmpty()

    init {
        val attrsTypeArray = context.obtainStyledAttributes(attrs, viewAttrsId)
        backgroundDrawable = attrsTypeArray.getDrawable(BACKGROUND_ATTR)
        name = attrsTypeArray.getString(TEXT_ATTR) ?: DEF_TEXT_ATTR

        initComponents()

        changeColor()

        if (hasText) {
            showText()
            changeText()
        } else {
            showImage()
            changeImage()
        }
    }

    private fun initComponents() {
        tail = findViewById(R.id.mood_tag__tail_iv)
        body = findViewById(R.id.mood_tag__body_frame_layout)
        head = findViewById(R.id.mood_tag__head_iv)
        textView = findViewById(R.id.mood_tag__body_tv__body_text_view)
        imageView = findViewById(R.id.mood_tag__body_tv__body_image_view)
    }

    private fun changeColor() {
        tail.setBackgroundColor(color)
        body.setBackgroundColor(color)
        head.setBackgroundColor(color)
    }

    private fun showText() {
        textView.visibility = View.VISIBLE
        imageView.visibility = View.GONE
    }

    private fun showImage() {
        imageView.visibility = View.VISIBLE
        textView.visibility = View.GONE
    }

    private fun changeText() {
        textView.text = name
    }

    private fun changeImage() {
        imageView.background = backgroundDrawable
    }
}