package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable

class Category @JvmOverloads constructor(
        context: Context,
        color: Color,
        name: String,
        radius: Float,
        icon: Drawable
){
    lateinit var color : Color
    lateinit var name : String
    lateinit var icon : Drawable
//    var radius : Float
//    set(value) = this

    lateinit var circle : CirclePackingLayout
}