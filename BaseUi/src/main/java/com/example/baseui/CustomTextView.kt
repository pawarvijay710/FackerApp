package com.example.baseui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.vjypwr.baseui.R

class CustomTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        attrs.let { applyAttributes(context, attrs, defStyleAttr) }
    }

    private fun applyAttributes(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val styledAttributes =
            context.obtainStyledAttributes(attrs, R.styleable.CustomTextView, defStyleAttr, 0)

        applyStyledAttributes(styledAttributes)
        styledAttributes.recycle()
    }

    private fun applyStyledAttributes(styledAttributes: TypedArray) = with(styledAttributes) {
        val labelType = getInt(R.styleable.CustomTextView_labelType, LabelType.UNDEFINED)
        applyLabel(labelType)
    }

    private fun applyLabel(labelType: Int) {
        Log.d("MyApp", "applyLabel")
        return when (labelType) {
            LabelType.HEADER -> {
                setStyle(FONT_LARGE, R.dimen.dimen_20_sp, R.color.FF252525)
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                gravity = Gravity.CENTER
            }
            LabelType.SUB_HEADER -> {
                setStyle(FONT_LARGE, R.dimen.dimen_14_sp, R.color.FF252525)
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                gravity = Gravity.CENTER
            }
            LabelType.TITLE -> {
                setStyle(FONT_LARGE, R.dimen.dimen_14_sp, R.color.FF252525)
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                gravity = Gravity.CENTER
            }
            LabelType.SUB_TITLE -> {
                setStyle(FONT_LARGE, R.dimen.dimen_14_sp, R.color.FF252525)
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                gravity = Gravity.CENTER
            }
            LabelType.DESCRIPTION -> {
                setStyle(FONT_LARGE, R.dimen.dimen_14_sp, R.color.FF252525)
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                gravity = Gravity.CENTER
            }
            LabelType.ERROR_TEXT -> {
                setStyle(FONT_LIGHT, R.dimen.dimen_14_sp, R.color.FFDB0011)
            }
            else -> Unit
        }

    }

    private fun setStyle(fontName: String, @DimenRes textSize: Int, @ColorRes textColor: Int) {
        Log.d("MyApp", "setStyle: $fontName")
        val typeFace = Typeface.createFromAsset(context.assets, "fonts/$fontName")
        Log.d("MyApp", "typeFace $typeFace")

        setTypeface(typeFace)
        setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(textSize))
        setTextColor(ResourcesCompat.getColor(resources, textColor, context.theme))
    }

    companion object {
        private class LabelType {
            companion object {
                const val UNDEFINED = -1
                const val HEADER = 0x00
                const val SUB_HEADER = 0x01
                const val TITLE = 0x02
                const val SUB_TITLE = 0x03
                const val DESCRIPTION = 0x04
                const val ERROR_TEXT = 0x05

            }
        }

        const val FONT_LARGE = "roboto_bold.ttf"
        const val FONT_MEDIUM = "roboto_medium.ttf"
        const val FONT_REGULAR = "roboto_regular.ttf"
        const val FONT_LIGHT = "roboto_light.ttf"
        const val FONT_THIN = "roboto_thin.ttf"
    }
}