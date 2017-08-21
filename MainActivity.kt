package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var button1 : CuboidButton
    lateinit var button2 : CuboidButton
    lateinit var holder : CuboidHolder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        holder = findViewById(R.id.myLayout) as CuboidHolder
        button1 = CuboidButton(this)
        button2 = CuboidButton(this)

        button1.radius = 5
        button2.radius = 10
        var list = listOf<CuboidButton>(button1, button2)






//        firstButton.setOnClickListener { Toast.makeText(this, "BUTTON 1", Toast.LENGTH_SHORT).show() }
//        secondButton.setOnClickListener { Toast.makeText(this, "BUTTON 2", Toast.LENGTH_SHORT).show() }
//        thirdButton.setOnClickListener { Toast.makeText(this, "BUTTON 3", Toast.LENGTH_SHORT).show() }

    }

    fun generateLayout(){

    }
}
