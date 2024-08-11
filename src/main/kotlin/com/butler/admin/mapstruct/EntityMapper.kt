package com.butler.admin.mapstruct

interface EntityMapper<E, D> {
    fun toDTO(entity:E):D
    fun toEntity(dto:D):E
}