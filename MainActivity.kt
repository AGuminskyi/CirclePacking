package com.idapgroup.artemhuminkiy.circlepacking

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var button1 : CuboidButton
    lateinit var button2 : CuboidButton
    lateinit var button3 : CuboidButton
    lateinit var button4 : CuboidButton
    lateinit var button5 : CuboidButton
    lateinit var button6 : CuboidButton
    lateinit var button7 : CuboidButton
    lateinit var button8 : CuboidButton
    lateinit var button9 : CuboidButton
    lateinit var button10 : CuboidButton
    lateinit var button11 : CuboidButton
    lateinit var button12 : CuboidButton
    lateinit var button13 : CuboidButton
    lateinit var holder : CuboidHolder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button1 = CuboidButton(this)
        button1.mCenterX = 1.4f
        button1.mCenterY = 1.4f

        button2 = CuboidButton(this)
        button2.mCenterX = 4.2f
        button2.mCenterY = 1.0f

        button3 = CuboidButton(this)
        button3.mCenterX = 6.8f
        button3.mCenterY = 1.4f

        button4 = CuboidButton(this)
        button4.mCenterX = 8.8f
        button4.mCenterY = 2.6f

        button5 = CuboidButton(this)
        button5.mCenterX = 1.6f
        button5.mCenterY = 4.0f

        button6 = CuboidButton(this)
        button6.mCenterX = 4.6f
        button6.mCenterY = 4.0f

        button2 = CuboidButton(this)
        button2.mCenterX = 4.2f
        button2.mCenterY = 1.0f

        button2 = CuboidButton(this)
        button2.mCenterX = 4.2f
        button2.mCenterY = 1.0f


        val coord1 : Coord = Coord(1.4f, 1.4f)
        val coord2 : Coord = Coord(4.2f, 1.0f)
        val coord3 : Coord = Coord(6.8f, 1.4f)
        val coord4 : Coord = Coord(8.8f, 2.6f)
        val coord5 : Coord = Coord(1.6f, 4.0f)
        val coord6 : Coord = Coord(4.6f, 4.0f)
        val coord7 : Coord = Coord(7.0f, 4.6f)
        val coord8 : Coord = Coord(1.0f, 6.4f)
        val coord9 : Coord = Coord(3.4f, 7.0f)
        val coord10 : Coord = Coord(6.4f, 7.0f)
        val coord11 : Coord = Coord(8.6f, 7.4f)
        val coord12 : Coord = Coord(2.0f, 9.0f)
        val coord13 : Coord = Coord(5.4f, 9.4f)
        val list = listOf<Coord>(coord1,coord2,coord3,coord4,coord5,coord6,coord7,coord8,coord9,
                coord10,coord11,coord12,coord13)
        val list1 = listOf<CuboidButton>(button1, button2, button3, button4)

        holder = findViewById(R.id.myLayout) as CuboidHolder
        holder.showCircles(list1)
        button1.setOnClickListener { Toast.makeText(this, "1", Toast.LENGTH_SHORT).show() }
        button2.setOnClickListener { Toast.makeText(this, "2", Toast.LENGTH_SHORT).show() }



//        firstButton.setOnClickListener { Toast.makeText(this, "BUTTON 1", Toast.LENGTH_SHORT).show() }
//        secondButton.setOnClickListener { Toast.makeText(this, "BUTTON 2", Toast.LENGTH_SHORT).show() }
//        thirdButton.setOnClickListener { Toast.makeText(this, "BUTTON 3", Toast.LENGTH_SHORT).show() }

    }

}
