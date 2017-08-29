package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.*
import android.widget.*
import com.bumptech.glide.Glide


class CirclePackingLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var exampleIcon = R.mipmap.ic_launcher
    private var MAX_RADIUS = 1.15f
    private var CONSTANT_SCALE = 10f
    private lateinit var imageView: ImageView
    private lateinit var text: TextView
    private var widthLayout: Int = 0
    private var coordinates: List<Coordinate> = listOf(
            Coordinate(1.8f, 1.7f), //1
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

    fun showCircles(categoryList: List<CircleView>) {
//        if (categoryList.size != coordinates.size)
//            return
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
        val radius = widthLayout / CONSTANT_SCALE
        coordinates.forEach {

            icon(exampleIcon)
            categoryName("Bonk")

            val circleView = CircleView(context).apply { setCoordinates(it, radius) }
            circleView.layoutParams = setLayoutParams(radius)
            circleView.setPadding(0, (radius / 4 + radius / 6).toInt(), 0, 0)
            circleView.addView(imageView)
            circleView.addView(text)
            addView(circleView)
        }
    }

    fun icon(icon: Int) {
        exampleIcon = icon
        imageView = createImageView(icon)
    }

    fun categoryName(categoryName: String) {
        text = createTextView(imageView, categoryName)
    }

    private fun setLayoutParams(radius: Float) : LayoutParams {
        val layoutParam = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        layoutParam.height = (radius * MAX_RADIUS * 2).toInt() + 2
        layoutParam.width = (radius * MAX_RADIUS * 2).toInt() + 2
        return layoutParam
    }

    private fun createTextView(imageView: ImageView, categoryName: String): TextView {
        val relativeParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        relativeParams.addRule(RelativeLayout.BELOW, imageView.id)
        relativeParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        text = TextView(context)
        text.text = categoryName
        text.layoutParams = relativeParams

        return text
    }

    private fun createImageView(icon: Int): ImageView {
        val relativeParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        relativeParams.addRule(RelativeLayout.CENTER_HORIZONTAL)

        val imageView = ImageView(context)
//        Glide
//                .with(context)
//                .load("")
//                .into(imageView)
        val bitmap = BitmapFactory.decodeResource(resources, icon)
        val radius = widthLayout / CONSTANT_SCALE
        imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmap, (radius + radius / 4).toInt(), (radius + radius / 4).toInt(), false))
        imageView.id = 1
        imageView.layoutParams = relativeParams

        return imageView
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {

            //make your realization here
            Toast.makeText(context, "not in circle", Toast.LENGTH_SHORT).show()
            return false
        }
        return super.onTouchEvent(event)
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
