package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var circleView = CircleView(this)
        circleView.icon = "Hello"
        circleView.categoryName = "Bonk"

        val list = listOf<CircleView>(circleView)
        circlePackingLayout.showCircles(list)
    }
}
