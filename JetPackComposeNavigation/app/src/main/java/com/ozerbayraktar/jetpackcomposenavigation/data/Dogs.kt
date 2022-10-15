package com.ozerbayraktar.jetpackcomposenavigation.data


data class Dogs(
    val id :Int,
    val title:String,
    val sex:String,
    val age:Int,
    val description:String,
    val dogImageId:Int=0
) :java.io.Serializable