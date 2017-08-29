package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.widget.RelativeLayout
import android.widget.Toast
import java.util.*

class CircleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    var circle_color: Int = 0
    var icon : String = ""
    var categoryName : String = ""
    private var radius = 0f
    private var center_x = 0f
    private var center_y = 0f
    private var circlePaint: Paint? = null
    private val MAX_RADIUS = 1.15f

    override fun dispatchDraw(canvas: Canvas) {
        if (circle_color == 0) {
            circle_color = Color.BLACK
        }
        circlePaint = Paint()
        circlePaint!!.color = circle_color
        canvas.drawCircle(center_x, center_y, radius, circlePaint)
        gravity = Gravity.CENTER_HORIZONTAL
        super.dispatchDraw(canvas)
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

    fun inCircle(x: Float, y: Float): Boolean {
        val dx = (x - center_x) * (x - center_x)
        val dy = (y - center_y) * (y - center_y)
        val circle_radius = radius * radius
        return (dx + dy) < circle_radius
    }

    fun setCoordinates(coord: Coordinate, radius: Float) {
        this.radius = radius * MAX_RADIUS
        this.x = coord.x * radius - this.radius
        this.y = coord.y * radius - this.radius
        center_x = this.radius
        center_y = this.radius
//    this.setBackgroundColor(com.idapgroup.artemhuminkiy.circlepacking.color())
        circle_color = color()
    }
}

fun color(): Int {
    val random = Random()
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    return color
}
