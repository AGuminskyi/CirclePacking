package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

class CirclePackingLayout @JvmOverloads constructor(
        context: Context,
        attributes: AttributeSet ?= null,
        defStyle: Int = 0,
        defStyleRes: Int = 0

): FrameLayout(context, attributes, defStyle, defStyleRes) {

    private var circleNumber: Int = 0
    private var smallestRadius: Double = 0.0
    private var circle_r: Float = 0.0F
    private var fill_r: Float = 0.9F

//    companion object {
//        val FILL_RATIO: FloatArray = floatArrayOf(
//                2.0000000000000000000000000000F,
//                4.1213203435596425732025330863F,
//                5.3710092413335613914277771031F,
//                6.6329437841857758045605037908F,
//                8.0262833439235407884100010519F)
//
//
//    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_component, this, true)
    }

    fun setCircleNum(curcleNumber: Int){
        if(this.circleNumber == curcleNumber)
            return
        this.circleNumber = circleNumber
        smallestRadius = circle_r /

    }
}