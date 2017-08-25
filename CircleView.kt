package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
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
    val MAX_RADIUS = 1.15f
    lateinit var list : MutableList<CircleView>
    var text: String? = null
    private var bitmap: Bitmap? = null
    private var widthLayout: Int = 0
    private var circlePaint: Paint? = null
    private var max_Width = 80
    private var max_Height = 80
    private var coordinates: List<Coordinate> = listOf(
            Coordinate(1.8f, 1.7f)) //1
//            Coordinate(4.2f, 1.2f), //2
//            Coordinate(6.5f, 2.2f), //3
//            Coordinate(8.8f, 3.0f), //4
//            Coordinate(1.6f, 4.0f), //5
//            Coordinate(4.3f, 4.0f), //6
//            Coordinate(7.0f, 4.6f), //7
//            Coordinate(1.2f, 6.4f), //8
//            Coordinate(3.5f, 7.0f), //9
//            Coordinate(6.0f, 6.9f), //10
//            Coordinate(8.6f, 7.4f), //11
//            Coordinate(2.0f, 9.0f), //12
//            Coordinate(5.0f, 9.0f)) //13


    init {
        includeFontPadding = false
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        widthLayout = minOf(measuredHeight, measuredWidth)
    }

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
//        includeFontPadding = false
        canvas.drawCircle(center_x, center_y, radius, circlePaint)
        if (icon != 0) {
            bitmap = BitmapFactory.decodeResource(resources, icon)
            imageIcon(canvas, circlePaint!!)
            setText("")
        } else {
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

    fun createCircles() : CircleView{

        val circle = CircleView(context)
            circle.radius = widthLayout / 10f * MAX_RADIUS
            circle.x = center_x - radius / 2
            circle.y = center_y - radius / 2
//            this.setBackgroundColor(com.idapgroup.artemhuminkiy.circlepacking.color())
            circle.circle_color = color()
            circle.text = "BONK"
        return circle

//        return list
    }

}

//fun CircleView.setCoordinates(coord: Coordinate, radius: Float) {
//    center_x = coord.x * radius
//    center_y = coord.y * radius
//    this.x = center_x - radius / 2
//    this.y = center_y - radius / 2
//    this.setBackgroundColor(com.idapgroup.artemhuminkiy.circlepacking.color())
//    circle_color = color()
//    text = "BONK"
//
////     icon = R.mipmap.ic_launcher
//}

fun color(): Int {
    val random = Random()
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    return color
}
