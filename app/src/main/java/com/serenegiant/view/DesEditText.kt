package com.serenegiant.view

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.serenegiant.screenrecordingsample.R

class DesEditText : LinearLayout {

    var editable: Boolean = true
        set(value) {
            field = value
            editText.isEnabled = field
        }

    private val desTextView = AppCompatTextView(context).apply {
        this@DesEditText.addView(
            this,
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
    }

    private val editText = AppCompatEditText(context).apply {
        this@DesEditText.addView(
            this,
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
    }

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        orientation = HORIZONTAL
        context.obtainStyledAttributes(attrs, R.styleable.DesEditText).use {
            val title = it.getString(R.styleable.DesEditText_title)
            val hint = it.getString(R.styleable.DesEditText_android_hint)
            val inputType =
                it.getInt(R.styleable.DesEditText_android_inputType, EditorInfo.TYPE_CLASS_NUMBER)
            desTextView.text = title
            editText.inputType = inputType
            editText.hint = hint
        }

    }


    fun getText(): String {
        val text = editText.text?.toString()
        if (TextUtils.isEmpty(text)) {
            return editText.hint?.toString() ?: ""
        }
        return text?: ""
    }

}