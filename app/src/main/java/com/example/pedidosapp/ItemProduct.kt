package com.example.pedidosapp

import android.graphics.drawable.Drawable

data class ItemProduct(
    var idProduct : String = "",
    var nomProduct : String = "",
    var descProduct: String = "",
    var tipProduct : String = "",
    var marcProduct : String = "",
    var uniProduct : String = "",
    var preProduct : Float = 0.0f ,
    var imgProduct : String = ""
)
