package com.wnsgml972.strada.api.v1.option.bean.service

import com.wnsgml972.strada.api.v1.option.bean.domain.BeanOption
import com.wnsgml972.strada.api.v1.ordering.service.toDto
import com.wnsgml972.strada.api.v1.ordering.service.toEntity
import com.wnsgml972.strada.exception.BadRequestException

fun BeanOption.toDto() = BeanOptionDTO(
    this.id ?: throw BadRequestException("$id must not null"),
    this.orderingDetail.toDto(),
    this.grindType
)

fun BeanOptionDTO.toEntity() = BeanOption.of(
    this.orderingDetail.toEntity(),
    this.grindType,
    this.id
)
