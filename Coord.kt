package com.idapgroup.artemhuminkiy.circlepacking

/**
 * Created by artemhuminkiy on 8/21/17.
 */

class Coord{
    var x = 0f
    var y = 0f


    constructor() {}

    constructor(xValue: Float, yValue: Float) {
        this.x = xValue
        this.y = yValue
    }

    internal fun setX(value: Float) {
        this.x = value
    }

    internal fun setY(value: Float) {
        this.y = value
    }
}
