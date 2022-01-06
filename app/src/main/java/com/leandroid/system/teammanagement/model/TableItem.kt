package com.leandroid.system.teammanagement.model

data class TableItem(
    val pos : Int,
    val team : String,
    val points : Int,
    val played : Int,
    val won : Int,
    val tie : Int,
    val lost : Int,
    val gf : Int,
    val gc : Int,
    val dif : Int
) {


}