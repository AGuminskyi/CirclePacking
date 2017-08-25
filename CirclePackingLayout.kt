package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.os.Build
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.view.Gravity
import android.widget.RelativeLayout


class CirclePackingLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var widthLayout: Int = 0
    private var coordinates: List<Coordinate> =  listOf(Coordinate(1.8f, 1.7f), //1
                                                        Coordinate(4.2f, 1.2f), //2
                                                        Coordinate(6.5f, 2.2f), //3
                                                        Coordinate(8.8f, 3.0f), //4
                                                        Coordinate(1.6f, 4.0f), //5
                                                        Coordinate(4.3f, 4.0f), //6
                                                        Coordinate(7.0f, 4.6f), //7
                                                        Coordinate(1.2f, 6.4f), //8
                                                        Coordinate(3.5f, 7.0f), //9
                                                        Coordinate(6.0f, 6.9f), //10
                                                        Coordinate(8.6f, 7.4f), //11
                                                        Coordinate(2.0f, 9.0f), //12
                                                        Coordinate(5.0f, 9.0f)) //13

    fun showCircles() {
        onLaidOut {
            createCircles()
            invalidate()
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        widthLayout = minOf(measuredHeight, measuredWidth)

    }

    fun createCircles() {
        val radius = widthLayout / 10f
        coordinates.forEach {
//            val layoutParam : LayoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
//            layoutParams.setMargins(5, 10, 5, 5)
            val circleView = CircleView(context).apply { setCoordinates(it, radius)}
//            layoutParam.height = 60
//            layoutParam.width = 60
//            circleView.layoutParams = layoutParam
            addView(circleView)
            //addView(CircleView(context).apply { setCoordinates(it, radius)})
        }
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
