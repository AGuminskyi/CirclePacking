package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.view.View
import java.util.*

class CuboidHolder(context: Context) : View(context) {

    var buttons: List<CuboidButton>?  = null

    private var maxRadius : Int = 0
    private var minRadius : Int = 0
    private var numButtons : Int = 0

    private var centerX : Int = 0
    private var centerY : Int = 0

    private var heightLayout : Int = 0
    private var widthLayout : Int = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        heightLayout = measuredHeight
        widthLayout =  measuredWidth
        centerX = measuredWidth / 2
        centerY = measuredHeight /2
    }

    fun paintButtons(context: Context, cuboidButtons: List<CuboidButton>){
        buttons = cuboidButtons
        if(buttons == null)
            return
        maxRadius = buttons!!.maxBy { cuboidButton -> cuboidButton.radius }?.radius?: 0
        minRadius = buttons!!.minBy { cuboidButton -> cuboidButton.radius }?.radius?: 0
        numButtons = buttons!!.size

        var random : Random = Random()

        buttons!!.forEach { button ->
            button.x + centerX}


    }
}