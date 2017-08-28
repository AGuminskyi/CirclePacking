package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class CircleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0

) : TextView(context, attrs, defStyleAttr) {
    var circle_color: Int = 0
    var icon: Int = 0
    var radius = 0f
    var center_x = 0f
    var center_y = 0f
    var text: String? = null
    private var bitmap: Bitmap? = null
    private var circlePaint: Paint? = null
    val MAX_RADIUS = 1.15f
    private var max_Width = 100
    private var max_Height = 100

    override fun onDraw(canvas: Canvas) {
        val half_width = this.width / 2
        val half_height = this.height / 2
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
//        bitmap = BitmapFactory.decodeResource(resources, icon)
//        image.setImageBitmap(bitmap)
        canvas.drawCircle(center_x, center_y, radius, circlePaint)
        if (icon != 0) {
            bitmap = BitmapFactory.decodeResource(resources, icon)
            imageIcon(canvas, circlePaint!!, half_width, half_height)
        }
        setText(text)
        gravity = Gravity.CENTER_HORIZONTAL
        super.onDraw(canvas)
    }

    private fun imageIcon(canvas: Canvas, circlePaint: Paint, p1: Int, p2: Int) {
        val b2 = scaleBitmap(bitmap as Bitmap)
        canvas.drawBitmap(b2, p1 - b2.width * 0.5f, p2 - b2.height * 0.5f, null)
//        canvas.drawBitmap(b2, width * 0.5f, height * 0.5f, null)
    }

    private fun scaleBitmap(bitmap: Bitmap): Bitmap {
        max_Width = (radius).toInt()
        max_Height = (radius).toInt()
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

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action == MotionEvent.ACTION_DOWN) {
            if (inCircle(event.x, event.y)) {
                Toast.makeText(context, "x = " + event.x.toString() + " y = " + event.y + " in circle", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}


fun CircleView.inCircle(x: Float, y: Float): Boolean {
    val dx = (x - center_x) * (x - center_x)
    val dy = (y - center_y) * (y - center_y)
    val circle_radius = radius * radius
    return (dx + dy) < circle_radius
}

fun CircleView.setCoordinates(coord: Coordinate, radius: Float) {
    this.radius = radius * MAX_RADIUS
    this.x = coord.x * radius - this.radius
    this.y = coord.y * radius - this.radius
    center_x = this.radius
    center_y = this.radius
//    this.setBackgroundColor(com.idapgroup.artemhuminkiy.circlepacking.color())
    circle_color = color()
    text = "BONK"
}

fun color(): Int {
    val random = Random()
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    return color
}
