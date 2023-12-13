package com.example.baseui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.vjypwr.baseui.R
import com.vjypwr.baseui.databinding.CustomErrorViewBinding

class CustomErrorView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var binding = CustomErrorViewBinding.inflate(LayoutInflater.from(context), this)

    var text: String
        get() = binding.errorLabel.text.toString()
        set(value) {
            binding.errorLabel.text = value
        }

    init {
        orientation = HORIZONTAL
        attrs?.apply { applyAttributes(this, context) }
    }

    private fun applyAttributes(attrs: AttributeSet, context: Context?) {
        val typedArray = context?.obtainStyledAttributes(
            attrs,
            R.styleable.CustomErrorView, 0, 0
        )

        val errorText = typedArray?.getText(R.styleable.CustomErrorView_text)
        errorText?.let {
            binding.errorLabel.text = errorText
        }

        typedArray?.recycle()
    }

}