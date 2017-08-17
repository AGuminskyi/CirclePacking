package com.idapgroup.artemhuminkiy.circlepacking

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import de.hdodenhof.circleimageview.CircleImageView

class Category @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    var circles: List<CircleImageView> = listOf()

    fun initCircles(circle: List<CircleImageView>) {
        this.circles = circle
    }


    init {
        val numOfCircle: Int = circles.size
        var layoutParams: ViewGroup.LayoutParams
        val layoutInflator: LayoutInflater = context.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View = layoutInflator.inflate(R.layout.view_custom, null)

        //fill in any details dynamically here

        for (circle in circles) {
            view = layoutInflator.inflate(circle.id, null)
        }


        LayoutInflater.from(context).inflate(R.layout.view_custom, this, true)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.custom_component_attributes, 0, 0)
            val title = resources.getText(typedArray
                    .getResourceId(R.styleable.custom_component_attributes_custom_component_title, R.string.component_one))

//            my_title.text = title
//            my_edit.hint = "${resources.getString(R.string.hint_text)} $title"

            typedArray.recycle()
        }
    }
}