package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsoluteLayout.LayoutParams
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var layoutParams : LayoutParams
        layoutParams = LayoutParams(this, null)

        setContentView(R.layout.activity_main)




//        firstButton.setOnClickListener { Toast.makeText(this, "BUTTON 1", Toast.LENGTH_SHORT).show() }
//        secondButton.setOnClickListener { Toast.makeText(this, "BUTTON 2", Toast.LENGTH_SHORT).show() }
//        thirdButton.setOnClickListener { Toast.makeText(this, "BUTTON 3", Toast.LENGTH_SHORT).show() }

    }
}
