package com.wnsgml972.strada.api.v1.item.service

import com.wnsgml972.strada.api.v1.item.domain.Coffee
import com.wnsgml972.strada.api.v1.item.domain.NonCoffee

fun NonCoffee.toDto() = NonCoffeeDTO(
    this.id,
    this.url,
    this.price,
    this.description,
    this.category,
)
fun NonCoffeeDTO.toEntity() = NonCoffee(
    this.id,
    this.url,
    this.price,
    this.description,
    this.category,
)

