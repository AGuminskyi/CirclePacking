package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.os.Build
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.*
import android.widget.FrameLayout
import java.util.*


class CuboidHolder @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    var buttons: List<CuboidButton>? = null
    var finalCircles: MutableList<CuboidButton> = arrayListOf()

    private var maxRadius: Int = 0
    private var minRadius: Int = 0
    private var numButtons: Int = 0

    private val minSeparation: Float = 1f

    private var centerXLayout: Int = 0
    private var centerYLayout: Int = 0

    private var heightLayout: Int = 0
    private var widthLayout: Int = 0

    private val ITERATION_COUNTER: Int = 1

    private var draggingCircle: CuboidButton? = null

    fun showCircles(list: List<CuboidButton>) {
        onLaidOut {
            //    paintButtons(list)
            showButtons(list)
            finalCircles.forEach {
                addView(it)
            }
            invalidate()
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        heightLayout = measuredHeight
        widthLayout = measuredWidth
        centerXLayout = measuredWidth / 2
        centerYLayout = measuredHeight / 2
    }

    fun showButtons(cuboidButtons: List<CuboidButton>) {
        val radius = widthLayout / 10
        finalCircles = cuboidButtons as MutableList<CuboidButton>
        finalCircles.forEach { button ->
            button.radius = radius
            button.mCenterX = radius * button.mCenterX
            button.mCenterY = radius * button.mCenterY
        }

    }

//    fun paintButtons(cuboidButtons: List<CuboidButton>) {
//        buttons = cuboidButtons
//    if (buttons == null)
//    return
//    maxRadius = buttons!!.maxBy { cuboidButton -> cuboidButton.radius }?.radius ?: 0
//    minRadius = buttons!!.minBy { cuboidButton -> cuboidButton.radius }?.radius ?: 0
//    numButtons = buttons!!.size
//
//    val random: Random = Random()
//
//    buttons!!.forEach { button ->
//        button.mCenterX = centerXLayout + random.nextFloat() * minRadius
//        button.mCenterY = centerYLayout + random.nextFloat() * minRadius
//        button.radius = (minRadius + random.nextFloat() * (maxRadius - minRadius)).toInt()    // !!! Float -> Int, casting of types
//        finalCircles.add(button)
//    }
//
//    calculateCircle()
//
//}

//    fun distanceToCenterSq(circle: CuboidButton): Float {
//        val x_distance_sq: Float = (circle.mCenterX - centerXLayout) * (circle.mCenterX - centerXLayout)
//        val y_distance_sq: Float = (circle.mCenterY - centerYLayout) * (circle.mCenterY - centerYLayout)
//        return x_distance_sq + y_distance_sq
//    }
//
//    fun lengthSq(coord: Coord): Float {
//        return coord.x * coord.x + coord.y * coord.y
//    }
//
//    fun comparer(circle1: CuboidButton, circle2: CuboidButton): Int {
//        val d1 = distanceToCenterSq(circle1)
//        val d2 = distanceToCenterSq(circle2)
//        if (d1 < d2)
//            return 1
//        else if (d1 > d2)
//            return -1
//        else
//            return 0
//    }
//
//    fun normalize(coord: Coord): Coord {
//        val value = 1.0f / Math.sqrt(((coord.x * coord.x) + (coord.y * coord.y)).toDouble())
//        coord.x *= value.toFloat()
//        coord.y *= value.toFloat()
//        return coord
//    }
//
//    fun multiply(scaleFactor: Float, coord: Coord): Coord {
//        coord.x *= scaleFactor
//        coord.y *= scaleFactor
//        return coord
//    }
//
//    fun calculateCircle() {
//        finalCircles.sortWith(kotlin.Comparator { circle1, circle2 -> comparer(circle1, circle2) })
//        val minSeparationSq = minSeparation * minSeparation
//
//        for (i: Int in finalCircles.indices - 1) {
//            var j: Int = i + 1
//            while (j < finalCircles.size) {
//                if (i == j)
//                    continue
//                var coord: Coord = Coord(finalCircles[j].mCenterX - finalCircles[i].mCenterX, finalCircles[j].mCenterY - finalCircles[i].mCenterX)
//                val radius: Int = finalCircles[i].radius + finalCircles[j].radius
//
//                var d = lengthSq(coord) - minSeparationSq
//                val minSepSq = Math.min(d, minSeparationSq)
//                d -= minSepSq
//
//                if (d < (radius * radius) - 0.01) {
//                    coord = normalize(coord)
//                    coord = multiply(((radius - Math.sqrt(d.toDouble())) * 0.5f).toFloat(), coord)
//                    if (finalCircles[j] != draggingCircle) {
//                        finalCircles[j].mCenterX = finalCircles[j].mCenterX + coord.x
//                        finalCircles[j].mCenterY = finalCircles[j].mCenterY + coord.y
//                    }
//                    if (finalCircles[i] != draggingCircle) {
//                        finalCircles[i].mCenterX = finalCircles[i].mCenterX + coord.x
//                        finalCircles[i].mCenterY = finalCircles[i].mCenterY + coord.y
//                    }
//                }
//                j++
//            }
//        }
//        val damping = 0.1f / ITERATION_COUNTER
//        for (i: Int in finalCircles.indices) {
//            if (finalCircles[i] != draggingCircle) {
//                var coord: Coord = Coord(finalCircles[i].mCenterX - centerXLayout, finalCircles[i].mCenterY - centerYLayout)
//                coord = multiply(damping, coord)
//                finalCircles[i].mCenterX = finalCircles[i].mCenterX - coord.x
//                finalCircles[i].mCenterY = finalCircles[i].mCenterY - coord.y
//            }
//        }
//    }
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


