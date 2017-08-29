package com.idapgroup.artemhuminkiy.circlepacking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val circleView1 = CircleView(this)
//        circleView1.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView1.categoryName = "Masson's"
//
//        val circleView2 = CircleView(this)
//        circleView2.icon = "https://avatanplus.com/files/resources/mid/57055da631914153ecf5d13b.png"
//        circleView2.categoryName = "Nichosi"
//
//        val circleView3 = CircleView(this)
//        circleView3.icon = "https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png"
//        circleView3.categoryName = "Cubes"
//
//        val circleView4 = CircleView(this)
//        circleView4.icon = "https://hsto.org/storage/habraeffect/8e/de/8ede5c77f2055b9374613f69b39c8e1c.png"
//        circleView4.categoryName = "Mouse"
//
//        val circleView5 = CircleView(this)
//        circleView5.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView5.categoryName = "Masson's"
//
//        val circleView6 = CircleView(this)
//        circleView6.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView6.categoryName = "Masson's"
//
//        val circleView7 = CircleView(this)
//        circleView7.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView7.categoryName = "Masson's"
//
//        val circleView8 = CircleView(this)
//        circleView8.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView8.categoryName = "Masson's"
//
//        val circleView9 = CircleView(this)
//        circleView9.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView9.categoryName = "Masson's"
//
//        val circleView10 = CircleView(this)
//        circleView10.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView10.categoryName = "Masson's"
//
//        val circleView11 = CircleView(this)
//        circleView11.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView11.categoryName = "Masson's"
//
//        val circleView12 = CircleView(this)
//        circleView12.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView12.categoryName = "Masson's"
//
//        val circleView13 = CircleView(this)
//        circleView13.icon = "https://cs8.pikabu.ru/post_img/2016/02/17/10/145572598117693502.png"
//        circleView13.categoryName = "Masson's"

//        val list : MutableList<CircleView> = mutableListOf(circleView1,circleView2,circleView3,
//                circleView4,circleView5,circleView6,circleView7,circleView8,circleView9,circleView10,
//                circleView11,circleView12,circleView13)
        circlePackingLayout.showCircles(list)
    }
}
