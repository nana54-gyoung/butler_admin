package com.butler.admin.mapstruct

import com.butler.admin.api.ui.vo.ButlerPositionVO
import com.butler.admin.model.entity.ButlerPositionEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring") @Component
interface ButlerPositionMapstruct : EntityMapper<ButlerPositionEntity, ButlerPositionVO>{
    override fun toEntity(dto: ButlerPositionVO): ButlerPositionEntity

    override fun toDTO(entity: ButlerPositionEntity): ButlerPositionVO
}