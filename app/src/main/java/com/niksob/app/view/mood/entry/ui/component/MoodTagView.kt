package com.niksob.app.view.mood.entry.ui.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.niksob.app.R

const val TAG_ENVELOP_OTHER_TAGS = true
const val TAG_NOT_ENVELOP_OTHER_TAGS = false
private const val DEF_COLOR = R.color.grey
private const val DEF_TEXT = ""
private const val ENVELOP_TAG_MARGIN_START_IN_DP = -16f
private const val NOT_ENVELOP_TAG_MARGIN_START_IN_DP = 0f

class MoodTagView(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {

    var color: Int = DEF_COLOR
        set(newColor) {
            field = newColor
            changeTagColor(newColor)
        }

    var text: String = DEF_TEXT
        set(newText) {
            field = newText
            changeTagText(newText)
        }

    var isEnvelopsOtherTags: Boolean? = null
        set(isEnvelopsOtherTags) {

            if (isEnvelopsOtherTags == field) {
                return
            }
            field = isEnvelopsOtherTags

            changeMarginStart()
        }

    private val layout get() = R.layout.mood_tag_layout

    private lateinit var _rootView: View

    private lateinit var tailImageView: ImageView
    private lateinit var bodyTextView: TextView
    private lateinit var headImageView: ImageView

    init {
        initComponents()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        isEnvelopsOtherTags = TAG_ENVELOP_OTHER_TAGS
    }

    private fun initComponents() {

        _rootView = View.inflate(context, layout, this)

        tailImageView = _rootView.findViewById(R.id.mood_tag_layout2__mood_tail_image_view)
        bodyTextView = _rootView.findViewById(R.id.mood_tag_layout2__mood_body_text_view)
        headImageView = _rootView.findViewById(R.id.mood_tag_layout2__mood_head_image_view)
    }

    private fun changeTagColor(newColor: Int) {
        tailImageView.background.setTint(newColor)
        bodyTextView.setBackgroundColor(newColor)
        headImageView.background.setTint(newColor)
    }

    private fun changeTagText(newText: String) {
        bodyTextView.text = newText
    }

    private fun changeMarginStart() {

        if (layoutParams !is MarginLayoutParams) {
            return
        }

        val dp = toDp(
            if (isEnvelopsOtherTags!!) {
                ENVELOP_TAG_MARGIN_START_IN_DP
            } else {
                NOT_ENVELOP_TAG_MARGIN_START_IN_DP
            }
        )
        (layoutParams as MarginLayoutParams).marginStart = dp
    }

    private fun toDp(value: Float) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        resources.displayMetrics,
    ).toInt()
}