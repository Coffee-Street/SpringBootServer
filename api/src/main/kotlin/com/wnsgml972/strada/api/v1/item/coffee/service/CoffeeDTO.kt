package com.wnsgml972.strada.api.v1.item.coffee.service

import com.wnsgml972.strada.api.v1.item.coffee.domain.Bean

data class CoffeeDTO(
    val id: String,
    val url: String,
    val price: Int,
    val description: String,
    val category: String,
    val bean: ArrayList<Bean> = ArrayList()
)