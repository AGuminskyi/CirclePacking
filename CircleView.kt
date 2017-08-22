package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet

/**
 * Created by artemhuminkiy on 8/22/17.
 */
class CircleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : android.support.v7.widget.AppCompatTextView(context, attrs, defStyleAttr) {
    var circle_color: Int = 0
    var circle_hover_color: Int = 0
    private var default_color: Int = 0
    var circle_border_color: Int = 0
    var circle_border_radius: Int = 0
    var cr_icon: Int = 0
    var radius = 0f
    var center_x = 0f
    var center_y = 0f
    private var bitmap : Bitmap? = null

    fun init(attrs: AttributeSet) {

    }
}