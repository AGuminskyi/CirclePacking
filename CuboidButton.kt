package com.idapgroup.artemhuminkiy.circlepacking

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.TextView


class CuboidButton : android.support.v7.widget.AppCompatTextView  {
    private var circle_color: Int = 0
        set(value) {
            field = circle_color
        }
        get() = field

    private var circle_hover_color: Int = 0
        set(value) {
            field = circle_hover_color
        }
        get() = field

    private var circle_border_color: Int = 0
        set(value) {
            field = value
        }
        get() = field


    private var circle_border_radius: Int = 0
        set(value) {
            field = value
        }
        get() = field

    private var cr_icon: Int = 0
        set(value) {
            field = value
        }
        get() = field

    private var mRadius: Float = 0.toFloat()
        set(value) {
            field = value
        }
        get() = field

    private var default_color: Int = 0
    private var fontStyle: String? = ""
    private var circlePaint: Paint? = null
    private var circleBorder: Paint? = null
    private var circle_x: Int = 0
    private var circle_y: Int = 0
    private var radius = 0
    private var startcolor: Int = 0
    private var endcolor: Int = 0
    private var user_given_radius: Int = 0
    private val BORDER_RADIUS = 6
    private val max_Width = 80
    private val max_Height = 80
    private var ripleEffect: Boolean = false
    private var mPaint: Paint? = null
    private var mRectPaint: Paint? = null
    private var mCoord: Coord? = null
    internal var mCenterX: Float = 0f
    internal var mCenterY: Float = 0f
    private var b: Bitmap? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }


    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet) {
        mCoord = Coord()
        circlePaint = Paint()
        circleBorder = Paint()
        mPaint = Paint()
        mRectPaint = Paint()
        mRectPaint!!.isAntiAlias = true
        circlePaint!!.isAntiAlias = true
        circleBorder!!.isAntiAlias = true
        mPaint!!.isAntiAlias = true
        val properties = context.theme.obtainStyledAttributes(attrs, R.styleable.MyCircleView, 0, 0)
        try {
            circle_color = properties.getInt(R.styleable.MyCircleView_cub_color, Color.BLACK)
            circle_hover_color = properties.getInt(R.styleable.MyCircleView_cub_hover_color, Color.GRAY)
            circle_border_color = properties.getInt(R.styleable.MyCircleView_cub_border_color, Color.WHITE)
            user_given_radius = properties.getDimensionPixelSize(R.styleable.MyCircleView_cub_border_radius, BORDER_RADIUS)
            circle_border_radius = Math.min(user_given_radius, BORDER_RADIUS)
            cr_icon = properties.getResourceId(R.styleable.MyCircleView_cub_icon, 0)
            ripleEffect = properties.getBoolean(R.styleable.MyCircleView_cub_riple_effect, false)
            fontStyle = properties.getString(R.styleable.MyCircleView_cub_fontstyle)
            if (fontStyle != null) {
                val typeFace = Typeface.createFromAsset(context.assets, fontStyle)
                typeface = typeFace
            }
            startcolor = circle_color
            default_color = circle_color
            endcolor = circle_hover_color
            mPaint!!.color = Color.parseColor("#0DFFFFFF")
            mRectPaint!!.color = Color.parseColor("#0DFFFFFF")
            b = BitmapFactory.decodeResource(resources, cr_icon)
            cr_icon = cr_icon
        } catch (e: Exception) {
        } finally {
            properties.recycle()
        }
    }

    override fun onDraw(canvas: Canvas) {
        val half_width = this.width / 2
        val half_height = this.height / 2
        radius = Math.min(half_width, half_height) / 4
        if (half_width > half_height) {
            radius = half_height - 10
        } else {
            radius = half_width - 10
        }
        circle_x = half_width
        circle_y = half_height
        circlePaint!!.style = Paint.Style.FILL
        circlePaint!!.color = default_color
        canvas.drawCircle(half_width.toFloat(), half_height.toFloat(), radius.toFloat(), circlePaint!!)//ORIGNAL CIRCLE
        if (circle_border_radius != 0) {
            circleBorder!!.style = Paint.Style.STROKE
            circleBorder!!.strokeWidth = circle_border_radius.toFloat()
            circleBorder!!.color = circle_border_color
            this.setLayerType(View.LAYER_TYPE_HARDWARE, circleBorder)
            circleBorder!!.setShadowLayer(5.0f, 0.0f, 3.0f, Color.GRAY)
            canvas.drawCircle(half_width.toFloat(), half_height.toFloat(), radius.toFloat(), circleBorder!!) //BORDER CIRCLE
        }
        if (cr_icon != 0) {
            //circlePaint as Paint()
            imageIcon(canvas, circlePaint!!, half_width, half_height)
            text = ""
        } else {
            text = text
        }
        gravity = Gravity.CENTER
        if (ripleEffect) {
            if (mCoord!!.x != 0f && mCoord!!.y != 0f) {
                canvas.drawCircle(mCoord!!.x, mCoord!!.y, mRadius, mPaint!!)
            }
        }
        super.onDraw(canvas)
    }

    private fun imageIcon(canvas: Canvas, circlePaint: Paint, half_width: Int, half_height: Int) {
        val b2 = scaleBitmap(b as Bitmap)
        canvas.drawBitmap(b2, half_width - b2.width * 0.5f, half_height - b2.height * 0.5f, null)
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

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.actionMasked == MotionEvent.ACTION_DOWN) {
            if (inCircle(event.x, event.y, circle_x.toFloat(), circle_y.toFloat(), radius.toFloat())) {
                mCenterX = (translationX + width) / 2.0f
                mCenterY = (translationY + height) / 2.0f
                mCoord!!.setX(event.x)
                mCoord!!.setY(event.y)
                if (ripleEffect) {
                    rippleAnimation()
                }
            }
        }

        super.onTouchEvent(event)
        val action = event.action
        when (action) {
            MotionEvent.ACTION_UP -> if (inCircle(event.x, event.y, circle_x.toFloat(), circle_y.toFloat(), radius.toFloat())) {
                setColorAnimation(endcolor, startcolor)
            } else {
                setColorAnimation(endcolor, startcolor)
            }

            MotionEvent.ACTION_DOWN -> if (inCircle(event.x, event.y, circle_x.toFloat(), circle_y.toFloat(), radius.toFloat())) {
                setColorAnimation(startcolor, endcolor)

            }

            MotionEvent.ACTION_CANCEL -> {
                Log.e("called", "cancel else")
                default_color = circle_color
                setColorAnimation(endcolor, startcolor)
            }
        }
        invalidate()
        return true
    }

    private fun inCircle(x: Float, y: Float, circleCenterX: Float, circleCenterY: Float, circleRadius: Float): Boolean {
        val dx = Math.pow((x - circleCenterX).toDouble(), 2.0)
        val dy = Math.pow((y - circleCenterY).toDouble(), 2.0)

        if (dx + dy < Math.pow(circleRadius.toDouble(), 2.0)) {
            return true
        } else {
            return false
        }
    }

    fun rippleAnimation() {
        val interpolator = LinearInterpolator()
        val duration: Long = 500

        val animRadius = ObjectAnimator.ofFloat(this, "radius", 10f, width / 3f)
        animRadius.interpolator = interpolator
        animRadius.duration = duration

        val animAlpha = ObjectAnimator.ofInt(mPaint, "alpha", 200, 0)
        animAlpha.interpolator = interpolator
        animAlpha.duration = duration

        val animX = ObjectAnimator.ofFloat(mCoord, "x", mCoord!!.x, mCenterX)
        animX.interpolator = interpolator
        animX.duration = duration

        val animY = ObjectAnimator.ofFloat(mCoord, "y", mCoord!!.y, mCenterY)
        animY.interpolator = interpolator
        animY.duration = duration

        val animRectAlpha = ObjectAnimator.ofInt(mRectPaint, "alpha", 0, 100, 0)
        animRectAlpha.interpolator = interpolator
        animRectAlpha.duration = duration

        val animSetAlphaRadius = AnimatorSet()
        animSetAlphaRadius.playTogether(animRadius, animAlpha, animX, animY, animRectAlpha)
        animSetAlphaRadius.start()
    }

    fun setColorAnimation(start: Int, end: Int) {
        val animator = ValueAnimator.ofObject(ArgbEvaluator(), start, end)
        animator.duration = 500
        animator.addUpdateListener { animation ->
            default_color = animation.animatedValue as Int
            invalidate()
        }
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.start()
    }

    inner class Coord{
        var x : Float = 0f
        var y : Float = 0f

        constructor(){}

        constructor(xValue : Float, yValues : Float)  {
            this.x = xValue
            this.y = yValues
        }

        internal fun setX(value: Float){
            this.x = value
        }
        internal fun setY(value : Float){
            this.y = value
        }

    }


}