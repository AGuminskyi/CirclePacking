package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import java.util.*
import kotlin.collections.ArrayList

class CirclePackingLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var buttons: MutableList<CuboidButton> = arrayListOf()
    private var heightLayout: Int = 0
    private var widthLayout: Int = 0

    fun showCircles(list: List<CuboidButton>) {
        onLaidOut {
            showButtons(list)
            buttons.forEach {
                addView(it)
            }
            invalidate()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        heightLayout = measuredHeight
        widthLayout = measuredWidth
    }

    fun showButtons(cuboidButtons: List<CuboidButton>) {
        val radius = widthLayout / 10
        buttons = cuboidButtons as MutableList<CuboidButton>
        buttons.forEach { button ->
            button.radius = radius
            button.mCenterX = radius * button.mCenterX
            button.mCenterY = radius * button.mCenterY
        }


        fun View.onLaidOut(action: () -> Unit) {
            viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (ViewCompat.isLaidOut(this@onLaidOut)) {
                        viewTreeObserver.removeOnGlobalOnLayoutListener(this)
                        action()
                    }
                }
            })
        }

        fun ViewTreeObserver.removeOnGlobalOnLayoutListener(victim: ViewTreeObserver.OnGlobalLayoutListener) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                removeOnGlobalLayoutListener(victim)
            } else {
                @Suppress("DEPRECATION")
                removeGlobalOnLayoutListener(victim)
            }
        }
    }
}