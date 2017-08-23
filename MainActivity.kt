package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        circlePackingLayout.showCircles()
//        circle.text = "Hello"
//        circle.center_x = 120F
//        circle.center_y = 340F
//        circle.radius = 50F
    }

}
