package com.example.pedidosapp

import android.graphics.drawable.Drawable

data class ItemPedido(
    var idPedido : String = "",
    var tipPedido : String = "",
    var marcPedido : String = "",
    var uniPedido: String = "",
    var ubiPedido : String = "",
    var nomDesPedido : String = "",
    var prePedido: Float = 0.0f ,
    var cantPedido: Int = 0,
    var totalPagoPedido : String = "",
    var EmailDestPedido : String = "",
    var numTelfPedido : Int = 0,
    var fechaPedido : String = "",
    var tipoPagoPedido : String = "",
    var estadoEntregaPedido : String = "",
)
