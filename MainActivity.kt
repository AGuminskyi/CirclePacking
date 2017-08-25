package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


//        circlePackingLayout.showCircles()
        val circle = CircleView(this)
        circle.createCircles()
        circle.setOnClickListener { Toast.makeText(this, "1", Toast.LENGTH_SHORT).show() }
        container.addView(circle)
    }

}
