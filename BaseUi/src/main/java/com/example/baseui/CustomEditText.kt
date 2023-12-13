package com.example.baseui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.text.Editable
import android.text.InputFilter
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import com.example.baseui.CustomTextView.Companion.FONT_LIGHT
import com.vjypwr.baseui.R
import com.vjypwr.baseui.databinding.CustomEditTextBinding

class CustomEditText @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var binding = CustomEditTextBinding.inflate(LayoutInflater.from(context), this)

    private var showError = 0

    private val editText: EditText by lazy { binding.editTextField }
    private val errorView by lazy { binding.errorTextView }

    private val onLayoutChangeListener = object : OnLayoutChangeListener {
        override fun onLayoutChange(
            v: View?,
            left: Int,
            top: Int,
            right: Int,
            bottom: Int,
            oldLeft: Int,
            oldTop: Int,
            oldRight: Int,
            oldBottom: Int
        ) {
            removeOnLayoutChangeListener(this)
        }
    }

    var text: Editable?
        get() = binding.editTextField.text
        set(value) {
            binding.editTextField.text = value
        }

    var hint: CharSequence?
        get() = binding.editTextField.hint
        set(value) {
            binding.editTextField.hint = value
        }

    var error: String?
        get() = errorView.text
        set(value) {
            errorView.text = value ?: ""
            if (errorView.visibility != View.GONE) {
                when (showError) {
                    ErrorVisibility.YES_DEFAULT -> errorView.visibility = when {
                        value.isNullOrBlank() -> View.INVISIBLE
                        else -> View.VISIBLE
                    }
                    else -> errorView.visibility = when {
                        value.isNullOrBlank() -> View.INVISIBLE
                        else -> View.VISIBLE
                    }
                }
            }
        }

    init {
        orientation = VERTICAL
        attrs.let { applyAttribute(context, attrs, defStyleAttr, defStyleRes) }
        isFocusable = true
        isFocusableInTouchMode = true
    }

    private fun applyAttribute(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) {
        val styledAttribute = context?.obtainStyledAttributes(
            attrs,
            R.styleable.CustomEditText,
            defStyleAttr,
            defStyleRes
        )
        applyStyledAttribute(styledAttribute)
        styledAttribute?.recycle()
    }

    private fun applyStyledAttribute(styledAttribute: TypedArray?) = with(styledAttribute) {
        val maxLength = this?.getInt(R.styleable.CustomEditText_maxLength, 0)
        if (maxLength != null) {
            if (maxLength >= 0) {
                editText.filters = arrayOf(InputFilter.LengthFilter(maxLength))
            }
        }

        val text = this?.getString(R.styleable.CustomEditText_text)
        text?.let { it ->
            this@CustomEditText.setText(it)
        }

        val maxLines = this?.getInt(R.styleable.CustomEditText_maxLines, 1)
        if (maxLines != null) {
            if (maxLines <= 0) {
                editText.maxLines = maxLines
            }
        }

        val hint = this?.getString(R.styleable.CustomEditText_hint)
        hint.let {
            editText.hint = hint
            this@CustomEditText.hint = hint
        }

        this?.getInt(R.styleable.CustomEditText_showError, ErrorVisibility.YES).also {
            if (it != null) {
                showError = it
                if (showError == ErrorVisibility.NO) {
                    errorView.visibility = View.GONE
                }
            }
        }

        val error = this?.getString(R.styleable.CustomEditText_error)
        error.let {
            this@CustomEditText.error = it
        }

        val inputType =
            this?.getInt(R.styleable.CustomEditText_inputType, EditorInfo.TYPE_CLASS_TEXT)
        if (inputType != null) {
            editText.inputType = inputType
        }

        addOnLayoutChangeListener(onLayoutChangeListener)

        val typeFace = Typeface.createFromAsset(context.assets, "fonts/$FONT_LIGHT")
        editText.typeface = typeFace

    }

    @Suppress("unused")
    fun setText(resurceId: Int) = editText.setText(resurceId)

    fun setText(text: String) {
        editText.setText(text)
        editText.setSelection(editText.text.length)
    }

    private class ErrorVisibility {
        companion object {
            const val NO = 0
            const val YES = 1
            const val YES_DEFAULT = 2
        }
    }
}