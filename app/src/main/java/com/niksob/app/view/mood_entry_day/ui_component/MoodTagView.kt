package com.niksob.app.view.mood_entry_day.ui_component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.niksob.app.R

private const val DEF_COLOR = R.color.grey
private const val DEF_TEXT = ""
private const val DP_MARGIN_START = -16f

open class MoodTagView(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    var color = DEF_COLOR
        set(newColor) {
            field = newColor
            changeColor(newColor)
        }

    var text = DEF_TEXT
        set(newText) {
            field = newText
            changeText(newText)
        }

    protected val layout get() = R.layout.mood_tag_layout

    protected lateinit var baseView: View

    protected lateinit var tailImageView: ImageView
    protected lateinit var bodyTextView: TextView
    protected lateinit var headImageView: ImageView

    init { initComponents() }

    override fun onFinishInflate() {
        super.onFinishInflate()
        setStartIndent()
    }

    private fun initComponents() {

        baseView = inflate(context, layout, this)

        tailImageView = baseView.findViewById(R.id.mood_tag_layout2__mood_tail_image_view)
        bodyTextView = baseView.findViewById(R.id.mood_tag_layout2__mood_body_text_view)
        headImageView = baseView.findViewById(R.id.mood_tag_layout2__mood_head_image_view)
    }

    protected fun changeColor(color: Int) {
        tailImageView.background.setTint(color)
        bodyTextView.setBackgroundColor(color)
        headImageView.background.setTint(color)
    }

    protected fun setStartIndent() {
        (layoutParams as MarginLayoutParams).marginStart = toDp(DP_MARGIN_START)
    }

    protected fun changeText(text: String) {
        bodyTextView.text = text
    }

    private fun toDp(value: Float) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        resources.displayMetrics,
    ).toInt()
}