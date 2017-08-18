package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstButton.setOnClickListener { Toast.makeText(this, "BUTTON 1", Toast.LENGTH_SHORT).show() }
        secondButton.setOnClickListener { Toast.makeText(this, "BUTTON 2", Toast.LENGTH_SHORT).show() }
        thirdButton.setOnClickListener { Toast.makeText(this, "BUTTON 3", Toast.LENGTH_SHORT).show() }

        firstButton.circle_border_color =

//        var categ : Category(this, #f57f17, one)
//        val circle1 : Circle = Circle(5.3F)
//        val circle2 : Circle = Circle(4.2F)
//
//        val list : MutableList<Circle> = mutableListOf(circle1, circle2)
//        val circlePacking : CirclePackingLayout = CirclePackingLayout(this)
//
//        circlePacking.circles(list)
    }
}
