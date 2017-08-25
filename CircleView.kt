package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import java.util.*

class CircleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0

) : TextView(context, attrs, defStyleAttr) {
    var circle_color: Int = 0
    var icon: Int = 0
    var radius = 0f
    var center_x = 0f
    var center_y = 0f
    var text : String? = null
    private var bitmap: Bitmap? = null
    private var circlePaint: Paint? = null
    val MAX_RADIUS = 1.15f
    private var max_Width = 80
    private var max_Height = 80


    override fun onDraw(canvas: Canvas) {
        if (radius == 0f) {
            radius = 100f
        }
        if (circle_color == 0) {
            circle_color = Color.BLACK
        }
        circlePaint = Paint()
        circlePaint!!.style
        circlePaint!!.color = circle_color
        includeFontPadding = false
        canvas.drawCircle(center_x, center_y, radius, circlePaint)
        if (icon != 0) {
            bitmap = BitmapFactory.decodeResource(resources, icon)
            imageIcon(canvas, circlePaint!!)
            setText("")
        }
        else{
            setText(text)
        }

        super.onDraw(canvas)
    }

    private fun imageIcon(canvas: Canvas, circlePaint: Paint) {
        val b2 = scaleBitmap(bitmap as Bitmap)
        canvas.drawBitmap(b2, 0f, 0f, circlePaint)
    }

    private fun scaleBitmap(bitmap: Bitmap): Bitmap {
        var bm = bitmap
        var width = bm.width
        var height = bm.height
        if (width > height) {
            val ratio = width.toFloat() / max_Width
            width = max_Width
            height = (height / ratio).toInt()
        } else if (height > width) {
            val ratio = height.toFloat() / max_Height
            height = max_Height
            width = (width / ratio).toInt()
        } else {
            height = max_Height
            width = max_Width
        }

        bm = Bitmap.createScaledBitmap(bm, width, height, true)
        return bm
    }
}
 fun CircleView.setCoordinates(coord: Coordinate, radius : Float){
     this.radius = radius * MAX_RADIUS
     center_x = coord.x * radius
     center_y = coord.y * radius
     this.x = center_x - radius/2
     this.y = center_y - radius/2
//     this.height = 10
//     this.width = 10
//     this.setBackgroundColor(com.idapgroup.artemhuminkiy.circlepacking.color())
     circle_color = color()
     text = "BONK"

//     icon = R.mipmap.ic_launcher


 }

fun  color(): Int {
    val random = Random()
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    return color
}
