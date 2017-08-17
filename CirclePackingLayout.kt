package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import java.util.*
import kotlin.collections.ArrayList

class CirclePackingLayout @JvmOverloads constructor(
        context: Context
//        attributes: AttributeSet? = null,
//        defStyle: Int = 0,
//        defStyleRes: Int = 0
) : FrameLayout(context) {
//) : FrameLayout(context, attributes, defStyle, defStyleRes) {

    lateinit var circles: List<Circle>
    val minSeperation = 1F
    val packingCenter: Pair<Float, Float> = Pair(0F, 0F)


    fun circles(circles: List<Circle>) {
        this.circles = circles
        findCenter(this.circles)
    }

    private fun findCenter(circles: List<Circle>) {
        val maxRadius: Float = circles.maxBy { circle -> circle.radius }?.radius ?: 0f
        val minRadius: Float = circles.minBy { circle -> circle.radius }?.radius ?: 0f
        val random = Random()
        for (circle in circles) {
            circle.center = Pair(packingCenter.first + random.nextFloat() * minRadius,
                    packingCenter.second + random.nextFloat() * maxRadius)

        }
    }

    private fun distanceToCenter(circle: Circle): Float {
        val X_distance = circle.center.first - packingCenter.first
        val Y_distance = circle.center.second - packingCenter.second
        return (X_distance * X_distance + Y_distance * Y_distance)
    }

    private fun compare(c1: Circle, c2: Circle): Int {
        val d1: Float = distanceToCenter(c1)
        val d2: Float = distanceToCenter(c2)
        if (d1 < d2)
            return 1
        else if (d1 > d2)
            return -1
        else
            return 0
    }

    val paint: Paint = Paint()
    lateinit var drawable: Array<Drawable>

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var widthSize: Int = MeasureSpec.getSize(widthMeasureSpec)
        var heightSize: Int = MeasureSpec.getSize(heightMeasureSpec)

        val widthPadding: Int = paddingLeft + paddingRight
        val heightPadding: Int = paddingTop + paddingBottom

        widthSize -= widthPadding
        heightSize -= heightPadding

        var length : Int = Math.min(widthSize, heightSize)

//        setMeasuredDimension()
    }

    init {
//        LayoutInflater.from(context).inflate(R.layout.view_custom_component, this, true)

    }

}
