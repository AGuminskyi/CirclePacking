package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        circlePackingLayout.showCircles()
//        circlePackingLayout.setOnTouchListener { view, motionEvent -> Toast.makeText(this, view.x.toString() + " " + view.y, Toast.LENGTH_SHORT).show() }
    }

}
